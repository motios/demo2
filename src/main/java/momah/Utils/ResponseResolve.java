package momah.Utils;

public class ResponseResolve {
    private int code;
    private String descroption;

    public ResponseResolve() {
    }

    public ResponseResolve(int code, String descroption) {
        this.code = code;
        this.descroption = descroption;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescroption() {
        return descroption;
    }

    public void setDescroption(String descroption) {
        this.descroption = descroption;
    }
}
