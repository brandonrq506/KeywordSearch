package Filter.Behavior;

import Conversations.Message;

public class MessageLevelFilter extends FilterBehavior {

    @Override
    public boolean filter() {
        boolean found = false;
        //Each message
        for (Message m : messages) {
            //Is compared against each keywords
            for (String k : keywords) {
                if (k.contains("-")) {
                    found = groupKeyFinder(m, k.split("-"));
                } else {
                    found = individualKeyFinder(m, k);
                }

                if (found) {
                    super.setKeyword(k);
                    break;
                }
            }
            if (found) {
                m.setPassedFilter();
                break;
            }
        }
        return found;
    }

    private boolean groupKeyFinder(Message messa, String[] key) {
        for (String keyword : key) {
            if (!messa.getText().contains(keyword)) {
                return false;
            }
        }
        return true;
    }

    private boolean individualKeyFinder(Message messa, String key) {
        return messa.getText().contains(key);
    }
}
