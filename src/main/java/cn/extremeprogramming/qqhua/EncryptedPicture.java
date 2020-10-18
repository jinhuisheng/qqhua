package cn.extremeprogramming.qqhua;

/**
 * @author huisheng.jin
 * @date 2020/10/18.
 */
public class EncryptedPicture {
    private final String message;
    private final byte[] picture;

    public EncryptedPicture(String message, byte[] picture) {
        this.message = message;
        this.picture = picture;
    }

    public String getMessage() {
        return message;
    }

    public byte[] getPicture() {
        return picture;
    }

}
