package cl.intelidata.amicarsvl.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.jam.superutils.FastFileTextReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivo {

    public static Logger logger = LoggerFactory.getLogger(Archivo.class);
    private String strPathEntrada;
    private String strPathSalida;
    // Extension archivo modificado a csv
    private String CSV = "_pro.csv";

    public Archivo(String strDirectorioEntrada, String strDirectorioSalida) {
        setPath(strDirectorioEntrada.trim(), strDirectorioSalida.trim());
    }

    public java.util.List<String> leer(String strArchivo, String strCabecera) {
        // Atributos y variables locales
        String strLinea = "";
        java.util.List<String> lista = new java.util.ArrayList<String>();
        try {
            logger.info("leyendo del archivo");
            // Crea el objeto que leera el archivo
            FastFileTextReader fastFileTextReader = new FastFileTextReader(this.getStrPathEntrada() + strArchivo.trim(), FastFileTextReader.UTF_8, 1024 * 40);
            // Comienza la lectura del archivo linea por linea
            while ((strLinea = fastFileTextReader.readLine()) != null) {
                logger.info("leyendo la linea: " + strLinea); //
                // Eliminar
                // insertar lectura de los archivos
                if (!strLinea.startsWith(strCabecera)) {
                    lista.add(strLinea);
                }

            }
            // Intenta el cierre del objeto que lee el archivo
            try {
                fastFileTextReader.close();
            } catch (Exception ex) {
                logger.error("Problemas al cerrar el archivo", ex);
            }
            // Confirma la lectura exitosa
            logger.info("Proceso del archivo teminado con exito");
        } catch (FileNotFoundException fe) {
            logger.error("El archivo " + strArchivo + " no fue encontrado", fe);
        } catch (Exception ex) {
            logger.error("Problemas al leer el archivo", ex);
        }
        return lista;
    }

    public void guardarLista(java.util.List<String> lista, String strRuta, String strExtension) {
        try {
            this.guardarLista(lista, strRuta, null, strExtension);
        } catch (Exception e) {
            logger.error("Problemas al guardar el archivo", e);
        }
    }

    public void guardarLista(java.util.List<String> lista, String strRuta, String strCabecera, String strExtension) {
        logger.info("SAVE LIST TO FILE {} | {} | {} | {}", lista, strRuta, strCabecera, strExtension);
        // Atributos y variables locales
        java.io.BufferedWriter bufferedWriter = null;
        java.io.BufferedWriter bufferedWriterArchivo = null;
        // Comienza la escritura del archivo
        String archivo = System.currentTimeMillis() + "." + strExtension;
        String archivoFinal = strRuta.trim() + archivo;
        strRuta = this.getStrPathSalida() + strRuta.trim();

        String strArchivo = strRuta.trim() + archivo;
        try {
            bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(strArchivo));
            logger.info("Creando el archivo", strArchivo);
            if (strCabecera != null) {
                // Inserta la cabecera del archivo
                logger.info("Insertando Cabecera");
                bufferedWriter.append(strCabecera);
                bufferedWriter.newLine();
            }
            // Lee la lista y escribe el archivo
            logger.info("Escribiendo los datos");
            for (String strDatos : lista) {
                bufferedWriter.append(strDatos);
                bufferedWriter.newLine();
            }
            bufferedWriterArchivo = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(strRuta + "Generado.txt"), "UTF-8"));
            bufferedWriterArchivo.append(archivoFinal);
            bufferedWriterArchivo.newLine();
        } catch (java.io.IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                bufferedWriter.close();
                bufferedWriterArchivo.close();
            } catch (java.io.IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    public void guardarListaCSV(java.util.List<String> lista, String strNombreArchivo, String strCabecera) {
        // Atributos y variables locales
        java.io.BufferedWriter bufferedWriter = null;
        // Comienza la escritura del archivo
        strNombreArchivo = this.getStrPathSalida() + strNombreArchivo.trim();
        String strArchivo = strNombreArchivo.trim() + System.currentTimeMillis() + this.CSV;
        try {
            bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(strArchivo), "UTF-8"));
            logger.info("Creando el archivo", strArchivo);
            if (strCabecera != null) {
                // Inserta la cabecera del archivo
                logger.info("Insertando Cabecera");
                bufferedWriter.append(strCabecera);
                bufferedWriter.newLine();
            }
            // Lee la lista y escribe el archivo
            logger.info("Escribiendo los datos");
            for (String strDatos : lista) {
                bufferedWriter.append(strDatos);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            // Cierra el buffer de escritura
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    public void guardarListaCSV(java.util.List<String> lista, String strNombreArchivo) {
        try {
            this.guardarListaCSV(lista, strNombreArchivo, null);
        } catch (Exception ex) {
            logger.error("Problemas la guardar el archivo", ex);
        }
    }

    private void setPath(String strDirectorioEntrada, String strDirectorioSalida) {

        logger.info("Seteando los directorios de entrada y salida");
        setStrPathEntrada(strDirectorioEntrada);
        setStrPathSalida(strDirectorioSalida);
        logger.info("Directorios verificados y listo para la indexacion");
    }

    /**
     * @return the strPathEntrada
     */
    public String getStrPathEntrada() {
        return strPathEntrada;
    }

    /**
     * @param strPathEntrada the strPathEntrada to set
     */
    public void setStrPathEntrada(String strPathEntrada) {
        this.strPathEntrada = strPathEntrada;
    }

    /**
     * @return the strPathSalida
     */
    public String getStrPathSalida() {
        return strPathSalida;
    }

    /**
     * @param strPathSalida the strPathSalida to set
     */
    public void setStrPathSalida(String strPathSalida) {
        this.strPathSalida = strPathSalida;
    }

    /**
     * @param CSV the CSV to set
     */
    public void setCSV(String CSV) {
        this.CSV = CSV;
    }
}
