/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relatorios;

/**
 *
 * @author User
 */
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Conexao;

public class Relatorio {

    public static void relatorio(String nomeRelatorio, String chave, int parametro) {
        Conexao c = new Conexao();
        c.conectar();
        try {

            Map<String, Object> parameters = new HashMap<>();
            parameters.put(chave, parametro);

            JasperCompileManager.compileReportToFile(nomeRelatorio + ".jrxml");
            JasperPrint print = JasperFillManager.fillReport(nomeRelatorio + ".jasper", parameters, c.conector);
            JasperViewer viewer = new JasperViewer(print, true);
            viewer.setVisible(true);
            JasperExportManager.exportReportToPdfFile(print, nomeRelatorio + ".pdf");

        } catch (JRException e) {
            throw new RuntimeException("ImpossÃ­vel abrir relatÃ³rio! ", e);
        } finally {
            if (c.conector != null) {
                c.desconectar();
            }

        }

    }
    public static void main(String[] args) {
        relatorio("AlunoFiltro","",0);
    }
}

