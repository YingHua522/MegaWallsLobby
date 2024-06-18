package cn.infnetwork.megawallslobby.database;

import java.util.*;
import java.util.Map.Entry;

public class KeyValue {
    private final Map<Object, Object> keyvalues = new HashMap();

    public KeyValue() {
    }

    public KeyValue(String key, Object value) {
        this.add(key, value);
    }

    public KeyValue add(String key, Object value) {
        this.keyvalues.put(key, value);
        return this;
    }

    public String[] getKeys() {
        return this.keyvalues.keySet().toArray(new String[0]);
    }

    public String getString(String key) {
        Object obj = this.keyvalues.get(key);
        return obj == null ? "" : obj.toString();
    }

    public Object[] getValues() {
        List<Object> keys = new ArrayList();
        Iterator var2 = this.keyvalues.entrySet().iterator();

        while (var2.hasNext()) {
            Entry<Object, Object> next = (Entry) var2.next();
            keys.add(next.getValue());
        }

        return keys.toArray(new Object[0]);
    }

    public boolean isEmpty() {
        return this.keyvalues.isEmpty();
    }

    public String toCreateString() {
        StringBuilder sb = new StringBuilder();

        for (Entry<Object, Object> objectObjectEntry : this.keyvalues.entrySet()) {
            Entry<Object, Object> next = (Entry) objectObjectEntry;
            sb.append("`");
            sb.append(next.getKey());
            sb.append("` ");
            sb.append(next.getValue());
            sb.append(", ");
        }

        return sb.substring(0, sb.length() - 2);
    }

    public String toInsertString() {
        String ks = "";
        String vs = "";

        Entry next;
        for (Iterator var3 = this.keyvalues.entrySet().iterator(); var3.hasNext(); vs = vs + "'" + next.getValue() + "', ") {
            next = (Entry) var3.next();
            ks = ks + "`" + next.getKey() + "`, ";
        }

        return "(" + ks.substring(0, ks.length() - 2) + ") VALUES (" + vs.substring(0, vs.length() - 2) + ")";
    }

    public String toKeys() {
        StringBuilder sb = new StringBuilder();

        for (Object next : this.keyvalues.keySet()) {
            sb.append("`");
            sb.append(next);
            sb.append("`, ");
        }

        return sb.substring(0, sb.length() - 2);
    }

    public String toString() {
        return this.keyvalues.toString();
    }

    public String toUpdateString() {
        StringBuilder sb = new StringBuilder();
        Iterator var2 = this.keyvalues.entrySet().iterator();

        while (var2.hasNext()) {
            Entry<Object, Object> next = (Entry) var2.next();
            sb.append("`");
            sb.append(next.getKey());
            sb.append("`='");
            sb.append(next.getValue());
            sb.append("' ,");
        }

        return sb.substring(0, sb.length() - 2);
    }

    public String toWhereString() {
        StringBuilder sb = new StringBuilder();

        for (Entry<Object, Object> objectObjectEntry : this.keyvalues.entrySet()) {
            Entry<Object, Object> next = (Entry) objectObjectEntry;
            sb.append("`");
            sb.append(next.getKey());
            sb.append("`='");
            sb.append(next.getValue());
            sb.append("' and ");
        }

        return sb.substring(0, sb.length() - 5);
    }
}
