package cl.intelidata.amicarsvl.servlet;

import cl.intelidata.amicarsvl.Validator;
import cl.intelidata.amicarsvl.DB;
import cl.intelidata.amicarsvl.jpa.Proceso;
import cl.intelidata.amicarsvl.util.Text;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Maze
 */
public class Lecturas extends HttpServlet {

    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(Lecturas.class);
    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * <p>
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Proceso proc = null;
        Validator val = new Validator();
        DB t = new DB();

        logger.info("INIT PROCESS");
        try {
            String cotiz = request.getParameter(Text.COTIZACION);
            String cli = request.getParameter(Text.CLIENTE);

            logger.info("VALIDATE INPUTS");
            if (val.validateInputs(cli, cotiz)) {
                cotiz = val.desencryptInput(cotiz);
                logger.info("GET PROCESO");
                proc = t.getProceso(Integer.parseInt(cotiz));

                if (proc != null) {
                    t.actualizarProceso(proc, 'r');
                } else {
                    logger.info("ERROR BD: NOT FOUND PROCESO {}", proc);
                }
            } else {
                logger.error("ERROR: URL PARAMS NOT VALID");
            }

            logger.info("REGISTER PROCESS: " + request.getParameter(Text.CLIENTE) + " | " + request.getParameter(Text.COTIZACION));
            this.returnImage(response);
        } catch (Exception ex) {
            logger.error("ERROR PROCESS FAILED {}", ex);
        } finally {
            logger.info("FINISH PROCESS");
        }
    }

    private void returnImage(HttpServletResponse response) throws Exception {
        logger.info("SHOW IMAGE");
        OutputStream out = null;

        try {
            response.setContentType("image/png");
            String pathToWeb = getServletContext().getRealPath(File.separator);

            File f = new File(pathToWeb + "blank.png");
            logger.info("GET IMAGE", f.getAbsolutePath());
            BufferedImage bi = ImageIO.read(f);
            out = response.getOutputStream();
            ImageIO.write(bi, "png", out);
        } catch (Exception ex) {
            logger.error("ERROR SHOW IMAGE FAILED {}", ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * <p>
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * <p>
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * <p>
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
