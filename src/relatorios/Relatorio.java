/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *

/**
 *
 * @author User
 */
package relatorios;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import util.Conexao;

public class Relatorio {

    public static void relatorio(String nomeRelatorio, String chave, int parametro) {
    Conexao c = new Conexao();
    c.conectar();
    try {
        String caminhoBase = "Relatorios/";
        String jrxmlPath = caminhoBase + nomeRelatorio + ".jrxml";
        String jasperPath = caminhoBase + nomeRelatorio + ".jasper";
        String pdfPath = caminhoBase + nomeRelatorio + ".pdf";

        // Verifica se o arquivo existe
        File arquivoJrxml = new File(jrxmlPath);
        File arquivoJasper = new File(jasperPath);

        if (!arquivoJrxml.exists() && !arquivoJasper.exists()) {
            System.out.println("Nenhum arquivo de relatório encontrado com nome: " + nomeRelatorio);
            return;
        }

        // Parâmetros do relatório
        Map<String, Object> parameters = new HashMap<>();
        if (chave != null && !chave.isEmpty()) {
            parameters.put(chave, parametro);
        }

        // Compila o .jrxml se necessário
        if (arquivoJrxml.exists()) {
            JasperCompileManager.compileReportToFile(jrxmlPath);
        }

        JasperPrint print = JasperFillManager.fillReport(jasperPath, parameters, c.conector);
        JasperViewer.viewReport(print, false);
        JasperExportManager.exportReportToPdfFile(print, pdfPath);

    } catch (JRException e) {
        throw new RuntimeException("Erro ao gerar relatório!", e);
    } finally {
        c.desconectar();
    }
}

    public static void main(String[] args) {
        relatorio("AlunoFiltro","",0);
    }

}
