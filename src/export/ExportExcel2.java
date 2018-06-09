package export;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Ano;



public class ExportExcel2 {

	public void expExcel(String caminho,String[][][] lista,List<Ano> ano) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(new File(caminho));

			HSSFSheet firstSheet[] = new HSSFSheet[ano.size()]; 
			for (int i = 0; i < firstSheet.length; i++) {
				firstSheet[i] = workbook.createSheet(ano.get(i).getNome());
			}

			int i = 0;
			for (int j = 0; j < firstSheet.length; j++) {
				i = 0;
				for (int j2 = 0; j2 < lista[0].length; j2++) {
					HSSFRow row = firstSheet[j].createRow(i);
					for (int j3 = 0; j3 < lista[0][0].length; j3++) {	
						row.createCell(j3).setCellValue(lista[j][j2][j3]);
					}
					i++;
				}
			
			}
			
			workbook.write(fos);
			JOptionPane.showMessageDialog(null, "Salvo");
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
