package cl.intelidata.amicarsvl.util;

import cl.intelidata.amicarsvl.conf.Configuracion;
import static cl.intelidata.amicarsvl.conf.Configuracion.logger;
import cl.intelidata.amicarsvl.jpa.Proceso;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tools {

    public static final Logger LOGGER = Logger.getLogger(Tools.class.getName());

    public static Timestamp nowDate() {
        logger.info("GET DATE");
        Date fecha = new Date();
        Timestamp time = new Timestamp(fecha.getTime());

        return time;
    }

    public static String fullURL(String urlBase, HashMap<String, String> params) {
        logger.info("CREATE URL TO ", urlBase);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String param = entry.getKey() + "=" + entry.getValue() + "&";
            urlBase = urlBase.concat(param);
        }

        if (urlBase.endsWith("&")) {
            urlBase = urlBase.substring(0, urlBase.length() - 1);
        }

        return urlBase;
    }

    public static void redirect(HttpServletRequest request, HttpServletResponse response, char opt) {
        logger.info("REDIRECTO TO ANOTHER PAGE");
        response.setContentType("text/html");
        String site = Text.AMICAR_URL;

        if (opt == 'L') {
            try {
                logger.info("Obteniendo URL Landing desde archivo properties");
                site = Configuracion.getInstance().getInitParameter("dominioLanding");

                if (!site.trim().endsWith("?")) {
                    site = site.trim().concat("?");
                }

                if (request.getQueryString() != null) {
                    logger.info("Redireccionando hacia Landing");

                    MCrypt mcrypt = new MCrypt();
                    String des = MCrypt.bytesToHex(mcrypt.encrypt("desinscrito"));
                    site = site.concat(request.getQueryString()).concat("&action=").concat(des);
                } else {
                    logger.warn("Parametros nulos cambiando URL hacia Amicar");
                }
            } catch (Exception ex) {
                logger.error("", ex);
            }
        }

        logger.info("Redireccionando a ", site);
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY); // SC_MOVED_TEMPORARILY | SC_MOVED_PERMANENTLY
        response.setHeader("Location", site);
    }

    public static void mailEjecutivo(Proceso proceso) {
        try {
            Archivo archivo = new Archivo(Configuracion.getInstance().getInitParameter("salidaemmesaging"), Configuracion.getInstance().getInitParameter("salidaemmesaging"));
            List<String> mail = new ArrayList<String>();
            List<String> list = new ArrayList<String>();

            list.add(Text.LLAVE_INICIO);
            list.add(proceso.getEjecutivosidEjecutivo().getCorreoEjecutivo());
            list.add(proceso.getClientesidCliente().getRutCliente());
            list.add(proceso.getEjecutivosidEjecutivo().getLocalesidLocal1().getNombreLocal());
            list.add(proceso.getClientesidCliente().getEmailCliente());
            list.add(proceso.getVendedoresidVendedor().getNombreVendedor());
            list.add(proceso.getFechaClickLink().toString());

            String line = formatLine(list);
            mail.add(line);
            archivo.guardarLista(mail, "Ejecutivos", "txt");

            logger.info("Mail id: " + proceso.getIdProceso() + " cliente id: " + proceso.getClientesidCliente().getRutCliente() + " ejecutivo id: " + proceso.getEjecutivosidEjecutivo().getIdEjecutivo() + "  vendedor id: " + proceso.getVendedoresidVendedor().getIdVendedor() + " fecha envio: " + proceso.getFechaEnvio() + " fecha click: " + proceso.getFechaClickLink());
        } catch (Exception e) {
            logger.error("Error al generar la data para email.", e.getMessage());
        }
    }

    private static String formatLine(List<String> list) {
        String line = "";

        for (String l : list) {
            line = line.concat(l).concat("|");
        }

        return line;
    }
}
