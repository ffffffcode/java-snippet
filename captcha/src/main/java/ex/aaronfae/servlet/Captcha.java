package ex.aaronfae.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/captcha")
public class Captcha extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 68;
        int height = 22;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(new Color(240, 255, 255));
//        画背景
        graphics.fillRect(0, 0, width, height);

        char[] charArray = "abcdefghIjklmnpqrstuvwxyz23456789ABCDEFGHJKLMNPRSTUVWXYZ".toCharArray();
        StringBuffer captcha = new StringBuffer();
        Random random = new Random();
        int index;
        for (int i = 0; i < 4; i++) {
            index = random.nextInt(charArray.length);
            graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            graphics.drawString(charArray[index] + "", (i * 15) + 6, 18);
            captcha.append(charArray[index]);
        }
        request.getSession().setAttribute("captcha", captcha.toString());
        System.out.println(captcha);
        graphics.dispose();
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
