package cn.infnetwork.megawallslobby.tellraw;

public class JsonBuilder {
    public static String[] REPLACEMENT_CHARS = new String[128];

    static {
        for (int i = 0; i <= 31; ++i) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", i);
        }

        REPLACEMENT_CHARS[34] = "\\\"";
        REPLACEMENT_CHARS[92] = "\\\\";
        REPLACEMENT_CHARS[9] = "\\t";
        REPLACEMENT_CHARS[8] = "\\b";
        REPLACEMENT_CHARS[10] = "\\n";
        REPLACEMENT_CHARS[13] = "\\r";
        REPLACEMENT_CHARS[12] = "\\f";
    }

    StringBuilder json;

    public JsonBuilder() {
        this.json = new StringBuilder();
    }

    public JsonBuilder(String string) {
        this();
        this.append(string);
    }

    public void append(String value) {
        int last = 0;
        int length = value.length();

        for (int i = 0; i < length; ++i) {
            char c = value.charAt(i);
            String replacement;
            if (c < 128) {
                replacement = REPLACEMENT_CHARS[c];
                if (replacement == null) {
                    continue;
                }
            } else if (c == 8232) {
                replacement = "\\u2028";
            } else {
                if (c != 8233) {
                    continue;
                }

                replacement = "\\u2029";
            }

            if (last < i) {
                this.json.append(value, last, i);
            }

            this.json.append(replacement);
            last = i + 1;
        }

        if (last < length) {
            this.json.append(value, last, length);
        }

    }

    public void deleteLastChar() {
        this.json.deleteCharAt(this.json.length() - 1);
    }

    public boolean isEmpty() {
        return this.json.length() == 0;
    }

    public int length() {
        return this.json.length();
    }

    public String toString() {
        return this.json.toString();
    }
}
