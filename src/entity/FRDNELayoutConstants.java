package entity;

/*
 * @autor: Diego Salgado
 * Note that the index of every object in this class always is equal to position - 1 respect the layout document
 * this is due because the file lecture begins with 0 and IntDNE document begins with 1.
 * */

public class FRDNELayoutConstants {
	
	// Version 2.0 Code
	
	//	Register Types
	
	public final static int BEGIN_REGISTER = 0;
	public final static int END_REGISTER = 3;
	public final static int OPERATION_INDEX = 3;
    
    //		Identificação do arquivo de interface
    public final static String FILE_INTERFACE_ID = "000";
    
    //  	Dados cadastrais dos Parceiros Comerciais. 
    public final static String BUSSINESS_PARTNERS = "100";
    
    //  	Dados do cabeçalho do documento de transporte (DNE) utilizado pela transportadora para o calculo do frete
    public final static String DOCUMENT_HEADER = "140";
    
    //  	Dados cadastrais dos materiais
    public final static String MATERIAL_DATA = "150";
    
    //  	Dados dos itens do documento de transporte utilizado pela transportadora.
    public final static String ITEMS_MATERIAL_NF = "160";
    
    //  Register Constants
    
    //  	Identificação do arquivo de interface
    
    public final static int BEGIN_CHECK_ID = 3;
    public final static int END_CHECK_ID = 9;
    
    public final static String CHECK_ID = "IntDNE";
    
    //		Dados cadastrais dos Parceiros Comerciais.
    
    public final static int PARTNER_TYPE_INDEX = 19;
    public final static int BEGIN_ACTION_TYPE = 20;
    public final static int END_ACTION_TYPE = 34;
    public final static int BEGIN_PARTNER_NAME = 34;
    public final static int END_PARTNER_NAME = 74;
    public final static int BEGIN_PARTNER_ADDRESS = 74;
    public final static int END_PARTNER_ADDRESS = 124;
    public final static int BEGIN_PARTNER_COUNTY = 124;
    public final static int END_PARTNER_COUNTY = 164;
    public final static int BEGIN_PARTNER_CITY = 164;
    public final static int END_PARTNER_CITY = 194;
    public final static int BEGIN_PARTNER_STATE = 194;
    public final static int END_PARTNER_STATE = 197;
    public final static int BEGIN_PARTNER_CEP = 197;
    public final static int END_PARTNER_CEP = 204;
    
    //  	Dados do cabeçalho do documento de transporte (DNE) utilizado pela transportadora para o calculo do frete
    
    public final static int DOCUMENT_TYPE_INDEX = 3;
    public final static int BEGIN_TRANSMITTER_CNPJ = 4;
    public final static int END_TRANSMITTER_CNPJ = 20;
    public final static int BEGIN_FISCAL_NOTE = 20;
    
    // I remove two spaces that area actually white, that's no a good practice but it's quite real.
    public final static int END_FISCAL_NOTE = 30;
    public final static int BEGIN_DOCUMENT_SERIE = 32;
    public final static int END_DOCUMENT_SERIE = 35;
    public final static int BEGIN_DOCUMENT_EMISSION_DATE = 35;
    public final static int END_DOCUMENT_EMISSION_DATE = 45;
    public final static int BEGIN_DOCUMENT_SHIPMENT_DATE = 45;
    public final static int END_DOCUMENT_SHIPMENT_DATE = 55;
    public final static int ACTION_TYPE_INDEX = 55;
    public final static int BEGIN_RECEIEVER_CNPJ = 56;
    public final static int END_RECEIEVER_CNPJ = 71;
    
    //		Dados cadastrais dos materiais
    
    public final static int BEGIN_MATERIAL_DESCRIPTION = 4;
    public final static int END_MATERIAL_DESCRIPTION = 44;
    public final static int BEGIN_MATERIAL_CODE = 44;
    public final static int END_MATERIAL_CODE = 65;
    
    //		Dados dos itens do documento de transporte utilizado pela transportadora.
    
    
}
