package testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class CDIO {

	public void expExcel(String nomeArquivo) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet firstSheet = workbook.createSheet("Aba1");

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(new File(nomeArquivo));

			// Este trecho obtem uma lista de objetos do tipo CD

			// do banco de dados através de um DAO e itera sobre a lista

			// criando linhas e colunas em um arquivo Excel com o conteúdo

			// dos objetos.

			List<String> lista = new ArrayList<>();
			lista.add("t");
			lista.add("t2");
			lista.add("t3");
			int i = 0;

			for (String cd : lista) {
				HSSFRow row = firstSheet.createRow(i);

				row.createCell(0).setCellValue(cd);
				row.createCell(1).setCellValue(cd);

				i++;

			} // fim do for

			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao exportar arquivo");
		} finally {
			try {
				fos.flush();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // fim do metodo exp

}
