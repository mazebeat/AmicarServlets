package cl.intelidata.amicarsvl.servlet;

import cl.intelidata.amicarsvl.DB;
import cl.intelidata.amicarsvl.Validator;
import cl.intelidata.amicarsvl.jpa.Clientes;
import cl.intelidata.amicarsvl.util.Text;
import cl.intelidata.amicarsvl.util.Tools;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Maze
 */
public class Desinscritos extends HttpServlet {

    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(Desinscritos.class);
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

        Clientes cliente = null;
        Validator val = new Validator();
        DB t = new DB();
        char opt = 'A';

        logger.info("INIT PROCESS");
        try {
            String cotiz = request.getParameter(Text.COTIZACION);
            String cli = request.getParameter(Text.CLIENTE);

            logger.info("VALIDATE INPUTS");
            if (val.validateInputs(cli, cotiz)) {
                cli = val.desencryptInput(cli);
                logger.info("GET CLIENTE");
                cliente = t.getCliente(Integer.parseInt(cli));

                if (cliente != null) {
                    if (!cliente.getDesinscrito()) {
                        logger.info("UPDATE CLIENTE");
                        t.actualizarCliente(cliente);
                        logger.info("REGISTER CLIENTE {}", cliente);
                        opt = 'L';
                    } else {
                        logger.warn("CLIENTE YA DESISNCRITO {}", cliente);
                    }
                } else {
                    logger.info("ERROR DB: NOT FOUND CLIENTE {}", cliente);
                }
            } else {
                logger.warn("ERROR: URL PARAMS NOT VALID");
            }

            logger.info("REGISTER PROCESS: " + request.getParameter(Text.CLIENTE) + " | " + request.getParameter(Text.COTIZACION));
            Tools.redirect(request, response, opt);
        } catch (Exception ex) {
            logger.error("ERROR PROCESS FAILED {}", ex);
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
