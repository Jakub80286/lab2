import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Foto {

    public BufferedImage getZdjecia(String path) {
        BufferedImage zdjecie = null;
        try {
            zdjecie = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zdjecie;
    }
}
