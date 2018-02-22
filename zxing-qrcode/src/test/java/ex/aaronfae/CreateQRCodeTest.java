package ex.aaronfae;

import org.junit.Test;

import java.io.File;

public class CreateQRCodeTest {

    @Test
    public void testCreate() {
        try {
            new CreateQRCode().Create("test", new File("C:/Users/AaronFae/Desktop/QRCode.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}