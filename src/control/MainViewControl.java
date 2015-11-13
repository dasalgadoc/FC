package control;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Diego
 */
public class MainViewControl {
    
    public MainViewControl(){
        mainView = new view.MainView(this);
    }
    
    public void setInitialConditions(){
        mainView.getResultTable().setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "FRDNE", "Nota Fiscal", "Ciudad", "Estado"
            }
        ));
        mainView.getDestinyFoldersCheck().setSelected(false);
        mainView.getCompareFRDNECheck().setSelected(false);
        mainView.getGlobalStateLabel().setText(INITIAL_PARAMETERS);
        mainView.getComparatorAddressText().setText(null);
        mainView.getFRDNEAddressText().setText(null);
        mainView.getDestinyAddressText().setText(null);
        checkConditions();
    }
    
    public void checkConditions(){
        boolean destiny = mainView.getDestinyFoldersCheck().isSelected();
        boolean compare = mainView.getCompareFRDNECheck().isSelected();
        
        mainView.getDestinyAddressButton().setEnabled(destiny || compare);
        mainView.getComparatorAddressButton().setEnabled(compare);
        
        mainView.getStartProccessButton().setEnabled(checkStart(destiny, compare));
        mainView.getExportResultButton().setEnabled(checkTableDestiny(destiny));
        mainView.getExportComparatorButton().setEnabled(checkTableTxt(compare));
    }
    
    private boolean checkStart(boolean destiny, boolean compare){
        boolean result = false;
        if(!mainView.getFRDNEAddressText().getText().isEmpty() && !(destiny || compare)){
            result = true;
        }
        if(!mainView.getFRDNEAddressText().getText().isEmpty() && destiny && !mainView.getDestinyAddressText().getText().isEmpty()){
            result = true;
        }
        if(!mainView.getFRDNEAddressText().getText().isEmpty() && compare && !mainView.getDestinyAddressText().getText().isEmpty() &&
                !mainView.getComparatorAddressText().getText().isEmpty()){
            result = true;
        }
        /*
        if(result){
            mainView.getGlobalStateLabel().setText(READY);
        }else{
            mainView.getGlobalStateLabel().setText(INITIAL_PARAMETERS);
        }*/
        return result;
    }
    
    private boolean checkTableDestiny(boolean destiny){
        boolean result = false;
        if(mainView.getResultTable().getRowCount()>0){
            if(destiny && !mainView.getDestinyAddressText().getText().isEmpty()){
                result = true;
            }
        }
        return result;
    }
    
    private boolean checkTableTxt(boolean compare){
        boolean result = false;
        if(mainView.getResultTable().getRowCount()>0){
            if(compare && !mainView.getDestinyAddressText().getText().isEmpty() && !mainView.getComparatorAddressText().getText().isEmpty()){
                result = true;
            }
        }
        return result;
    }
    
    public void startProccess(){
        boolean result = proccess();
    }
    
    public void getARoute(String type, String component){
        view.FileChooser fileChooser = new view.FileChooser(this, type, component);
    }
    
    public void updateRoute(String component,String route){
        if(component.equals(FRDNE)){
            mainView.getFRDNEAddressText().setText(route);
        }else if(component.equals(DESTINY)){
            mainView.getDestinyAddressText().setText(route);
        }else if(component.equals(TXT)){
            mainView.getComparatorAddressText().setText(route);
        }
        checkConditions();
    }
    
    @SuppressWarnings("deprecation")
	private boolean proccess(){
        boolean result = false;
        try{
            folder = new java.io.File(mainView.getFRDNEAddressText().getText());
            if(folder.exists()){
                java.io.BufferedReader buffRead = null;
                files = folder.listFiles();
                mainView.getGlobalStateLabel().setText(FILE_FOUND);
                boolean foldersCenterCreated = false;
                boolean folderCompareCreated = false;
                // 05-Noviembre
                boolean foldersEmptyCreated = false;
                int emptyFiles = 0;
                int notEmptyFiles = 0;
                int majorDate1 = 0;
                int majorDate2 = 0;
                int equalDate = 0;
                //
                int countCopyFiles = 0;
                int caboFiles = 0;
                int sumareFiles = 0;
                int descartableFiles = 0;
                if(mainView.getDestinyFoldersCheck().isSelected()){
                	// 05-Noviembre
                    foldersEmptyCreated = createEmptyFolders();
                    if(!foldersEmptyCreated){
                    	javax.swing.JOptionPane.showMessageDialog(mainView, FAILURE_CREATING_FOLDERS, ERROR, 
                                javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                    //
                	/*
                	foldersCenterCreated = createCenterFolders();
                    if(!foldersCenterCreated){
                        javax.swing.JOptionPane.showMessageDialog(mainView, FAILURE_CREATING_FOLDERS, ERROR, 
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                    */
                }
                if(mainView.getCompareFRDNECheck().isSelected()){
                    folderCompareCreated = createCompareFolders();
                    if(!folderCompareCreated){
                        javax.swing.JOptionPane.showMessageDialog(mainView, FAILURE_CREATING_FOLDERS, ERROR, 
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
                for(java.io.File temp : files){
                    buffRead = new java.io.BufferedReader(new java.io.FileReader(temp));
                    int count = 0;
                    String currentLine;
                    String city = "No encontrada";
                    String state = "No encontrado";
                    String fiscalNote = "No encontrada";
                    // 05-Noviembre
                    String date1 = "No encontrada";
                    String date2 = "No encontrada";
                    //
                    // Lectura de Datos
                    while((currentLine = buffRead.readLine()) !=null){
                        if(count == entity.FRDNELayoutConstants.CITY_STATE_ROW){
                            city = currentLine.substring(entity.FRDNELayoutConstants.START_CITY, entity.FRDNELayoutConstants.END_CITY);
                            state = currentLine.substring(entity.FRDNELayoutConstants.START_STATE,entity.FRDNELayoutConstants.END_STATE);
                        } 
                        if(count == entity.FRDNELayoutConstants.FISCAL_NOTE_ROW){
                            fiscalNote = currentLine.substring(entity.FRDNELayoutConstants.START_FISCAL_NOTE,entity.FRDNELayoutConstants.END_FISCAL_NOTE);
                            // 05-Noviembre
                            date1 = currentLine.substring(entity.FRDNELayoutConstants.START_DATE_1,entity.FRDNELayoutConstants.END_DATE_1);
                            date2 = currentLine.substring(entity.FRDNELayoutConstants.START_DATE_2, entity.FRDNELayoutConstants.END_DATE_2);
                            if(new java.util.Date(date1).before(new java.util.Date(date2))){
                            	majorDate2++;
                            }else if (new java.util.Date(date1).after(new java.util.Date(date2))){
                            	majorDate1++;
                            }else{
                            	equalDate++;
                            }
                            //
                            break;
                        }
                        count++;
                    }
                    // Separación según vacios
                    if(foldersEmptyCreated){
                    	boolean empty = city.trim().isEmpty() || state.trim().isEmpty();
                    	if(empty){
                    		java.io.File to = new java.io.File(mainView.getDestinyAddressText().getText()+EMPTY+temp.getName());
                            java.nio.file.Files.copy(temp.toPath(), to.toPath());
                            emptyFiles++;
                    	}else{
                    		java.io.File to = new java.io.File(mainView.getDestinyAddressText().getText()+NOT_EMPTY+temp.getName());
                            java.nio.file.Files.copy(temp.toPath(), to.toPath());
                            notEmptyFiles++;
                    	}
                    }
                    // Separación según centro
                    if(foldersCenterCreated){
                        boolean descartable = checkDescartability(temp);
                        if(!descartable){
                            int fiscalNoteInt = 0;
                            try{
                                fiscalNoteInt = Integer.parseInt(fiscalNote);
                            }catch(Exception ex){}
                            if(fiscalNoteInt < entity.ClasificationConstants.CABO_NF || fiscalNoteInt > entity.ClasificationConstants.DESCARTABLE_NF || fiscalNoteInt == 0){
                                java.io.File to = new java.io.File(mainView.getDestinyAddressText().getText()+DESCARTABLE+temp.getName());
                                java.nio.file.Files.copy(temp.toPath(), to.toPath());
                                descartableFiles++;
                            }else if(fiscalNoteInt > entity.ClasificationConstants.SUMARE_NF){
                                java.io.File to = new java.io.File(mainView.getDestinyAddressText().getText()+SUMARE+temp.getName());
                                java.nio.file.Files.copy(temp.toPath(), to.toPath());
                                sumareFiles++;
                            }else if(fiscalNoteInt > entity.ClasificationConstants.CABO_NF && fiscalNoteInt < entity.ClasificationConstants.SUMARE_NF){
                                java.io.File to = new java.io.File(mainView.getDestinyAddressText().getText()+CABO+temp.getName());
                                java.nio.file.Files.copy(temp.toPath(), to.toPath());
                                caboFiles++;
                            }
                        }else{
                            descartableFiles++;
                        }
                    }
                    // Separación según lista
                    if(folderCompareCreated){
                        java.io.BufferedReader lectureFile = new java.io.BufferedReader(new java.io.FileReader(mainView.getComparatorAddressText().getText()));
                        String currentLineLecture;
                        while ((currentLineLecture = lectureFile.readLine()) != null) {
                            if(temp.getName().equals(currentLineLecture)){
                                java.io.File to = new java.io.File(mainView.getDestinyAddressText().getText()+COMPARE+temp.getName());
                                java.nio.file.Files.copy(temp.toPath(), to.toPath());
                                countCopyFiles++;
                                break;
                            }
                        }
                        lectureFile.close();
                    }
                    // Llenado de la tabla
                    String row[] = {temp.getName(), fiscalNote, city, state};
                    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) mainView.getResultTable().getModel();
                    model.addRow(row);
                }
                mainView.getGlobalStateLabel().setText(FILE_COUNT_HEAD + files.length + FILE_COUNT_TRAILER);
                // 05-Noviembre
                if(foldersEmptyCreated){
                	javax.swing.JOptionPane.showMessageDialog(mainView, COPY_FILES_HEAD + emptyFiles + COPY_FILES_TRAILER + EMPTY, INFORMATION, 
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                	javax.swing.JOptionPane.showMessageDialog(mainView, COPY_FILES_HEAD + notEmptyFiles + COPY_FILES_TRAILER + NOT_EMPTY, INFORMATION, 
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                	System.out.println("Mayores totales (Fecha 1): " + majorDate1 + " (Fecha 2): " + majorDate2);
                }
                //
                if(folderCompareCreated){
                    javax.swing.JOptionPane.showMessageDialog(mainView, COPY_FILES_HEAD + countCopyFiles + COPY_FILES_TRAILER + COMPARE, INFORMATION, 
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
                if(foldersCenterCreated){
                    javax.swing.JOptionPane.showMessageDialog(mainView, COPY_FILES_HEAD + caboFiles + COPY_FILES_TRAILER + CABO, INFORMATION, 
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    javax.swing.JOptionPane.showMessageDialog(mainView, COPY_FILES_HEAD + sumareFiles + COPY_FILES_TRAILER + SUMARE, INFORMATION, 
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    javax.swing.JOptionPane.showMessageDialog(mainView, COPY_FILES_HEAD + descartableFiles + COPY_FILES_TRAILER + DESCARTABLE, INFORMATION, 
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
                result = true;
                checkConditions();
            }else{
                javax.swing.JOptionPane.showMessageDialog(mainView, UNEXISTED_FOLDER, ERROR, 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }catch(IOException | HeadlessException ex){
            javax.swing.JOptionPane.showMessageDialog(mainView, UNEXPECTED_ERROR, ERROR, 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
    
    private boolean checkDescartability(java.io.File temp) throws FileNotFoundException, IOException{
        boolean descartable = false;
        int count = 0;
        String currentLine;
        java.io.BufferedReader buffRead = new java.io.BufferedReader(new java.io.FileReader(temp));
        while((currentLine = buffRead.readLine())!= null){
            if(count == 1){
                for(String tempString: entity.ClasificationConstants.DESCARTABLE_CRITERIA){
                    if(currentLine.contains(tempString)){
                        java.io.File to = new java.io.File(mainView.getDestinyAddressText().getText()+DESCARTABLE+temp.getName());
                        java.nio.file.Files.copy(temp.toPath(), to.toPath());
                        descartable = true;
                    }
                }
                break;
            }
            count++;
        }
        buffRead.close();
        return descartable;
    }
    
    private boolean createCenterFolders(){
        boolean success = (new java.io.File(mainView.getDestinyAddressText().getText()+CABO).mkdirs());
        boolean success1 = (new java.io.File(mainView.getDestinyAddressText().getText()+SUMARE).mkdirs());
        boolean success2 = ((new java.io.File(mainView.getDestinyAddressText().getText()+DESCARTABLE).mkdirs()));
        return success && success1 && success2;
    }
    
    private boolean createCompareFolders(){
        boolean result = (new java.io.File(mainView.getDestinyAddressText().getText()+COMPARE).mkdirs());
        return result;
    }
    
    // 05-Noviembre
    private boolean createEmptyFolders(){
    	boolean success =  (new java.io.File(mainView.getDestinyAddressText().getText()+EMPTY).mkdirs());
    	boolean success1 = (new java.io.File(mainView.getDestinyAddressText().getText()+NOT_EMPTY).mkdirs());
    	return success && success1;
    }
    //
    
    private final view.MainView mainView;
    private java.io.File folder;
    private java.io.File files[];
    
    // 05-Noviemnbre
    private final String EMPTY = "\\Vacios\\";
    private final String NOT_EMPTY = "\\Llenos\\"; 
    //
    
    private final String COMPARE = "\\ComparacionOK\\";
    private final String CABO = "\\Cabo\\";
    private final String SUMARE = "\\Sumare\\";
    private final String DESCARTABLE = "\\Descartable\\";
    private final String COPY_FILES_HEAD = "Se copiaron (";
    private final String COPY_FILES_TRAILER = ") archivos al directorio de destino: ";
    private final String UNEXISTED_FOLDER = "El directorio no existe.";
    private final String FAILURE_CREATING_FOLDERS = "Falla en la creación de directorios destino";
    private final String FILE_COUNT_HEAD = "Se encontraron (";
    private final String FILE_COUNT_TRAILER = ") archivos.";
    private final String FILE_FOUND = "Listando archivos.";
    private final String INITIAL_PARAMETERS = "Ingrese parámetros iniciales.";
    private final String READY = "Listo para procesar.";
    private final String UNEXPECTED_ERROR = "Error inesperado.";
    private final String ERROR = "Mensaje de Error.";
    private final String INFORMATION = "Mensaje de Información.";
    private final String FRDNE = "FRDNE";
    private final String DESTINY = "DESTINY";
    private final String TXT = "TXT";
}
