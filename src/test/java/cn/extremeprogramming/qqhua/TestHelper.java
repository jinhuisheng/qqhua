package cn.extremeprogramming.qqhua;

import java.io.IOException;

public class TestHelper {
    public static byte[] loadTestPicture(String picture) throws IOException {
        return TestHelper.class.getClassLoader().getResourceAsStream(picture).readAllBytes();
    }
}