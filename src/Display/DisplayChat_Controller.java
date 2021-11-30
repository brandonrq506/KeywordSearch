package Display;

public class DisplayChat_Controller {

    //Check if conversation has both
    protected boolean botFound = false;
    protected boolean agentFound = false;
    
    //Starting point for each
    protected int beginBot = -1;
    protected int endBot = -1;
    protected int beginAgent = -1;

    protected String chatInstance;

    public DisplayChat_Controller(String text) {
        this.chatInstance = determineInstance(text);
        markPoints(chatInstance, text);
    }

    private String determineInstance(String text) {
        if (text.contains("ios current customer")) {
            return "ios";
        } else if (text.contains("chat origin: ib dental chat")) {
            return "dtteam";
        } else if (text.contains("chat origin: sales chat team")) {
            return "sales";
        } else if (text.contains("smiledirectclub: thanks for contacting smiledirectclub")) {
            return "sdc";
        } else if (text.contains("mark molar, your smiledirectclub")
                || text.contains("i'm mark, your smiledirectclub")) {
            return "marki";
        } else if (text.contains("smiledirectclub: hi, i'm mark molar, a virtual assistant for smiledirectclub")) {
            return "marki2";
        } else if (text.contains("bot: i")) {
            return "adabot";
        }

        return "ios";
    }

    private void markPoints(String instance, String text) {
        switch (instance) {
            case "ios":
                beginAgent = text.indexOf("ios current customer agent") + 26;
                agentFound = true;
                break;
            case "dtteam":
                beginAgent = text.indexOf("chat origin: ib dental chat team - en agent") + 43;
                agentFound = true;
                break;
            case "sales":
                beginAgent = text.indexOf("chat origin: sales chat team - en agent") + 39;
                agentFound = true;
                break;
            case "sdc":
                botFound = true;
                beginBot = text.indexOf("smiledirectclub:") - 1;
                if (text.contains("let me transfer you to a smile expert")) {
                    endBot = text.indexOf("agent chatbot successfully transferred") - 1;
                    beginAgent = text.indexOf("transferred from smiledirectclub to") + 35;
                    agentFound = true;
                } else if (text.contains("let me transfer you to a live agent")) {
                    endBot = text.indexOf("agent chatbot transferred the chat") - 1;
                    beginAgent = text.indexOf("transferred from smiledirectclub to") + 35;
                    agentFound = true;
                }
                break;
            case "marki":
                botFound = true;
                if (text.contains("mark molar: hi, i'm mark molar")) {
                    beginBot = text.indexOf("mark molar: hi, i'm mark molar") - 1;
                } else if (text.contains("i'm mark, your smiledirectclub")) {
                    beginBot = text.indexOf("i'm mark, your smiledirectclub") - 1;
                }
                if (text.contains("agent chatbot successfully transferred")) {
                    endBot = text.indexOf("agent chatbot successfully transferred") - 1;
                    beginAgent = text.indexOf("chat transferred from mark molar to ") + 36;
                    if (beginAgent == 35) {
                        beginAgent = text.indexOf("chat transferred from mark to ") + 30;
                    }
                    agentFound = true;
                } else {
                    endBot = text.length() - 1;
                }
                break;
            case "adabot":
                //Estos chats de ADA siempre tienen bot
                botFound = true;
                if (text.contains("bot: i am your virtual assistant")) {
                    beginBot = text.indexOf("bot: i am your virtual assistant") - 1;
                } else if (text.contains("bot: i'm your virtual assistant")) {
                    beginBot = text.indexOf("bot: i'm your virtual assistant") - 1;
                }
                //Una vez que ya encontramos donde comienza el bot, analizamos el hand-off
                if (text.contains("presence message summary")) {
                    endBot = text.indexOf("bot: let me connect you") -1;
                    beginAgent = text.indexOf(". agent (");
                    agentFound = true;
                } else if(text.contains("bot: let me connect you")) {
                    endBot = text.indexOf("bot: let me connect you") -1;
                    beginAgent = text.indexOf(". agent (");
                    if(beginAgent == -1) {
                        beginAgent = text.indexOf("members. summary");
                        if(beginAgent == -1) {
                            //If by this point we don't have a reasonable solution, simply:
                            beginAgent = text.indexOf("visitor", endBot) -4;
                        }
                    }
                    agentFound = true;
                }
                break;
            case "marki2":
                botFound = true;
                if (text.contains("smiledirectclub: hi, i'm mark molar, a virtual assistant for smiledirectclub")) {
                    beginBot = text.indexOf("smiledirectclub: hi, i'm mark molar, a virtual assistant for smiledirectclub") - 1;
                }

                if (text.contains("chat transferred from smiledirectclub to ")) {
                    endBot = text.indexOf("chat transferred from smiledirectclub to ") - 1;
                    beginAgent = text.indexOf("chat transferred from smiledirectclub to ") + 41;
                    agentFound = true;
                } else {
                    endBot = text.length() - 1;
                }
                break;
            case "tycas":
                botFound = true;
                beginBot = text.indexOf("0kztycas") + 16;
                if (text.contains("chatbot successfully")) {
                    endBot = text.indexOf("agent chatbot successfully");
                    beginAgent = text.indexOf("from smiledirectclub chat to") + 29;
                    agentFound = true;
                } else if (text.contains("let's connect you to a smileexpert")) {
                    endBot = text.indexOf("let's connect you to a smileexpert");
                    beginAgent = text.indexOf("from smiledirectclub chat to") + 29;
                    agentFound = true;
                } else if (text.contains("let me transfer you to a smile expert")) {
                    endBot = text.indexOf("let me transfer you to a smile expert");
                    beginAgent = text.indexOf("from smiledirectclub chat to") + 29;
                    agentFound = true;
                } else {
                    endBot = text.length() - 1;
                }
                break;
            case "msea2":
                beginAgent = text.indexOf("transferred from smiledirectclub to") + 36;
                agentFound = true;
                break;
            case "tocas":
                botFound = true;
                beginBot = text.indexOf("0000kztocas") + 19;
                if (text.contains("chat with a smile expert")) {
                    endBot = text.indexOf("chat with a smile expert") + 25;
                    beginAgent = text.indexOf("from mark molar standard to") + 28;
                    agentFound = true;
                } else {
                    endBot = text.length() - 1;
                }
                break;
            case "udcas":
                botFound = true;
                beginBot = text.indexOf("0000kzudcas") + 19;
                if (text.contains("chat with a smile expert")) {
                    endBot = text.indexOf("chat with a smile expert") + 25;
                    beginAgent = text.indexOf("from mark molar standard to") + 28;
                    agentFound = true;
                } else {
                    endBot = text.length() - 1;
                }
                break;
        }
    }
}
