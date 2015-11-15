package control;

public class MainControl {
	
	public static void main(String[] args){
        MainViewControl mainViewControl = new MainViewControl();
        mainViewControl.setInitialConditions();
    }
	
	// Test Code - Uncommet to do test about FRDNE Layout
	/*
	private static java.io.BufferedReader buffRead;

	public static void main(String[] args){
		java.io.File file1 = new java.io.File("C:\\Users\\Diego\\Desktop\\Test\\FRDNE301015063645.txt");
		java.io.File file2 = new java.io.File("C:\\Users\\Diego\\Desktop\\Test\\FRDNE301015093738.txt");
		java.io.File file3 = new java.io.File("C:\\Users\\Diego\\Desktop\\Test\\FRDNE301015060616.txt");
		try {
			//printText(file1);
			//printText(file2);
			printText(file3);
		} catch (java.IO.IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printText(java.io.File file) throws java.io.IOException{
		buffRead = new java.io.BufferedReader(new java.io.FileReader(file));
		String currentLine;
		while((currentLine = buffRead.readLine()) !=null){
			if(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER).equals("000")){
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER));
				System.out.println(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_CHECK_ID, entity.FRDNELayoutConstants.END_CHECK_ID));
			}else
			if(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER).equals("100")){
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER)+"testtesttesttest");
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.PARTNER_TYPE_INDEX, entity.FRDNELayoutConstants.PARTNER_TYPE_INDEX+1));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_ACTION_TYPE, entity.FRDNELayoutConstants.END_ACTION_TYPE));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_PARTNER_NAME, entity.FRDNELayoutConstants.END_PARTNER_NAME));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_PARTNER_ADDRESS, entity.FRDNELayoutConstants.END_PARTNER_ADDRESS));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_PARTNER_COUNTY, entity.FRDNELayoutConstants.END_PARTNER_COUNTY));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_PARTNER_CITY, entity.FRDNELayoutConstants.END_PARTNER_CITY));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_PARTNER_STATE, entity.FRDNELayoutConstants.END_PARTNER_STATE));
				System.out.println(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_PARTNER_CEP, entity.FRDNELayoutConstants.END_PARTNER_CEP));
			}else
			if(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER).equals("140")){
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.DOCUMENT_TYPE_INDEX,entity.FRDNELayoutConstants.DOCUMENT_TYPE_INDEX+1));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_TRANSMITTER_CNPJ, entity.FRDNELayoutConstants.END_TRANSMITTER_CNPJ));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_FISCAL_NOTE, entity.FRDNELayoutConstants.END_FISCAL_NOTE));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_DOCUMENT_SERIE, entity.FRDNELayoutConstants.END_DOCUMENT_SERIE));
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_DOCUMENT_EMISSION_DATE, entity.FRDNELayoutConstants.END_DOCUMENT_EMISSION_DATE));
				System.out.println(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_DOCUMENT_SHIPMENT_DATE, entity.FRDNELayoutConstants.END_DOCUMENT_SHIPMENT_DATE));
			}else
			if(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER).equals("150")){
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER)+" ");
				System.out.print(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_MATERIAL_DESCRIPTION, entity.FRDNELayoutConstants.END_MATERIAL_DESCRIPTION));
				System.out.println(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_MATERIAL_CODE, entity.FRDNELayoutConstants.END_MATERIAL_CODE));;
			}else
			if(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER).equals("160")){
				System.out.println(currentLine.substring(entity.FRDNELayoutConstants.BEGIN_REGISTER, entity.FRDNELayoutConstants.END_REGISTER) + "OK!");
			}else{
				System.out.println("ERROR");
			}
			
		}
	}
	
	*/
}
