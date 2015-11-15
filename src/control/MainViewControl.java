package control;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author Diego
 */
public class MainViewControl {

	public MainViewControl() {
		mainView = new view.MainView(this);
	}

	public void setInitialConditions() {
		mainView.getDestinyFoldersCheck().setSelected(false);
		mainView.getCompareFRDNECheck().setSelected(false);
		mainView.getCityCheck().setSelected(false);

		mainView.getGlobalStateLabel().setText(INITIAL_PARAMETERS);
		mainView.getComparatorAddressText().setText(null);
		mainView.getFRDNEAddressText().setText(null);
		mainView.getDestinyAddressText().setText(null);

		checkConditions();
	}

	public void checkConditions() {
		boolean destiny = mainView.getDestinyFoldersCheck().isSelected();
		boolean compare = mainView.getCompareFRDNECheck().isSelected();
		boolean city = mainView.getCityCheck().isSelected();

		mainView.getDestinyAddressButton().setEnabled(
				destiny || compare || city);
		mainView.getComparatorAddressButton().setEnabled(compare);

		mainView.getStartProccessButton().setEnabled(
				checkStart(destiny, compare, city));
	}

	private boolean checkStart(boolean destiny, boolean compare, boolean city) {
		boolean result = false;
		if (!mainView.getFRDNEAddressText().getText().isEmpty()
				&& !(destiny || compare || city)) {
			result = true;
		}
		if (!mainView.getFRDNEAddressText().getText().isEmpty()
				&& (destiny || city)
				&& !mainView.getDestinyAddressText().getText().isEmpty()
				&& !compare) {
			result = true;
		}
		if (!mainView.getFRDNEAddressText().getText().isEmpty() && compare
				&& !mainView.getDestinyAddressText().getText().isEmpty()
				&& !mainView.getComparatorAddressText().getText().isEmpty()) {
			result = true;
		}
		if (result) {
			mainView.getGlobalStateLabel().setText(READY);
		} else {
			mainView.getGlobalStateLabel().setText(INITIAL_PARAMETERS);
		}
		return result;
	}

	public void getARoute(String type, String component) {
		@SuppressWarnings("unused")
		view.FileChooser fileChooser = new view.FileChooser(this, type,
				component);
	}

	public void updateRoute(String component, String route) {
		if (component.equals(FRDNE)) {
			mainView.getFRDNEAddressText().setText(route);
		} else if (component.equals(DESTINY)) {
			mainView.getDestinyAddressText().setText(route);
		} else if (component.equals(TXT)) {
			mainView.getComparatorAddressText().setText(route);
		}
		checkConditions();
	}

	@SuppressWarnings("deprecation")
	public void startProccess() {
		if (loadFiles()) {
			try {
				java.io.BufferedReader buffRead = null;
				boolean foldersCenterCreated = false;
				boolean folderCompareCreated = false;
				boolean foldersEmptyCreated = false;

				int countFiles = 0;
				int emptyFiles = 0;
				int notEmptyFiles = 0;
				int majorEmissionDate = 0;
				int majorShipmentDate = 0;
				int equalDate = 0;
				int countCopyFilesEmpty = 0;

				int countCopyFiles = 0;
				int caboFiles = 0;
				int sumareFiles = 0;
				int descartableFiles = 0;

				if (mainView.getDestinyFoldersCheck().isSelected()) {
					foldersCenterCreated = createCenterFolders();
					if (!foldersCenterCreated) {
						javax.swing.JOptionPane.showMessageDialog(mainView,
								FAILURE_CREATING_FOLDERS, ERROR,
								javax.swing.JOptionPane.ERROR_MESSAGE);
					}

				}

				if (mainView.getCityCheck().isSelected()) {
					foldersEmptyCreated = createEmptyFolders();
					if (!foldersEmptyCreated) {
						javax.swing.JOptionPane.showMessageDialog(mainView,
								FAILURE_CREATING_FOLDERS, ERROR,
								javax.swing.JOptionPane.ERROR_MESSAGE);
					}
				}

				if (mainView.getCompareFRDNECheck().isSelected()) {
					folderCompareCreated = createCompareFolders();
					if (!folderCompareCreated) {
						javax.swing.JOptionPane.showMessageDialog(mainView,
								FAILURE_CREATING_FOLDERS, ERROR,
								javax.swing.JOptionPane.ERROR_MESSAGE);
					}
				}

				for (java.io.File temp : files) {
					buffRead = new java.io.BufferedReader(
							new java.io.FileReader(temp));
					String currentLine;
					String city = "";
					String state = "";
					String fiscalNote = "";
					String emissionDate = "";
					String shipmentDate = "";

					// Lectura de Datos
					while ((currentLine = buffRead.readLine()) != null) {

						if (currentLine
								.substring(
										entity.FRDNELayoutConstants.BEGIN_REGISTER,
										entity.FRDNELayoutConstants.END_REGISTER)
								.equals(entity.FRDNELayoutConstants.BUSSINESS_PARTNERS)) {
							city = currentLine
									.substring(
											entity.FRDNELayoutConstants.BEGIN_PARTNER_CITY,
											entity.FRDNELayoutConstants.END_PARTNER_CITY)
									.trim();
							state = currentLine
									.substring(
											entity.FRDNELayoutConstants.BEGIN_PARTNER_STATE,
											entity.FRDNELayoutConstants.END_PARTNER_STATE)
									.trim();
						}

						if (currentLine
								.substring(
										entity.FRDNELayoutConstants.BEGIN_REGISTER,
										entity.FRDNELayoutConstants.END_REGISTER)
								.equals(entity.FRDNELayoutConstants.DOCUMENT_HEADER)) {
							fiscalNote = currentLine
									.substring(
											entity.FRDNELayoutConstants.BEGIN_FISCAL_NOTE,
											entity.FRDNELayoutConstants.END_FISCAL_NOTE);
							emissionDate = currentLine
									.substring(
											entity.FRDNELayoutConstants.BEGIN_DOCUMENT_EMISSION_DATE,
											entity.FRDNELayoutConstants.END_DOCUMENT_EMISSION_DATE);
							shipmentDate = currentLine
									.substring(
											entity.FRDNELayoutConstants.BEGIN_DOCUMENT_SHIPMENT_DATE,
											entity.FRDNELayoutConstants.END_DOCUMENT_SHIPMENT_DATE);
							if (new java.util.Date(emissionDate)
									.before(new java.util.Date(shipmentDate))) {
								java.io.File to = new java.io.File(mainView
										.getDestinyAddressText().getText()
										+ MAJOR_SHIPMENT
										+ temp.getName());
								java.nio.file.Files
										.copy(temp.toPath(), to.toPath());
								majorShipmentDate++;
							} else if (new java.util.Date(emissionDate)
									.after(new java.util.Date(shipmentDate))) {
								java.io.File to = new java.io.File(mainView
										.getDestinyAddressText().getText()
										+ MAJOR_EMISSION
										+ temp.getName());
								java.nio.file.Files
										.copy(temp.toPath(), to.toPath());
								majorEmissionDate++;
							} else {
								java.io.File to = new java.io.File(mainView
										.getDestinyAddressText().getText()
										+ EQUAL_DATA
										+ temp.getName());
								java.nio.file.Files
										.copy(temp.toPath(), to.toPath());
								equalDate++;
							}
						}
						countFiles++;
					}

					constructLog(temp.getName(), fiscalNote, city, state,
							emissionDate, shipmentDate, countFiles);

					// Separación según vacios
					if (foldersEmptyCreated) {
						if (city.isEmpty() || state.isEmpty()) {
							java.io.File to = new java.io.File(mainView
									.getDestinyAddressText().getText()
									+ EMPTY
									+ temp.getName());
							java.nio.file.Files
									.copy(temp.toPath(), to.toPath());
							emptyFiles++;
						} else {
							java.io.File to = new java.io.File(mainView
									.getDestinyAddressText().getText()
									+ NOT_EMPTY + temp.getName());
							java.nio.file.Files
									.copy(temp.toPath(), to.toPath());
							notEmptyFiles++;
						}
					}

					// Separación según centro
					if (foldersCenterCreated) {
						System.out.println(fiscalNote);
						boolean descartable = checkDescartability(temp);
						if (!descartable) {
							int fiscalNoteInt = 0;
							try {
								fiscalNoteInt = Integer.parseInt(fiscalNote);
							} catch (Exception ex) {
							}
							if (fiscalNoteInt < entity.ClasificationConstants.CABO_NF
									|| fiscalNoteInt > entity.ClasificationConstants.DESCARTABLE_NF
									|| fiscalNoteInt == 0) {
								java.io.File to = new java.io.File(mainView
										.getDestinyAddressText().getText()
										+ DESCARTABLE + temp.getName());
								java.nio.file.Files.copy(temp.toPath(),
										to.toPath());
								descartableFiles++;
							} else if (fiscalNoteInt > entity.ClasificationConstants.SUMARE_NF) {
								java.io.File to = new java.io.File(mainView
										.getDestinyAddressText().getText()
										+ SUMARE + temp.getName());
								java.nio.file.Files.copy(temp.toPath(),
										to.toPath());
								sumareFiles++;
							} else if (fiscalNoteInt > entity.ClasificationConstants.CABO_NF
									&& fiscalNoteInt < entity.ClasificationConstants.SUMARE_NF) {
								java.io.File to = new java.io.File(mainView
										.getDestinyAddressText().getText()
										+ CABO + temp.getName());
								java.nio.file.Files.copy(temp.toPath(),
										to.toPath());
								caboFiles++;
							}
						} else {
							descartableFiles++;
						}
					}
					// Separación según lista
					if (folderCompareCreated) {
						java.io.BufferedReader lectureFile = new java.io.BufferedReader(
								new java.io.FileReader(mainView
										.getComparatorAddressText().getText()));
						String currentLineLecture;
						while ((currentLineLecture = lectureFile.readLine()) != null) {
							if (temp.getName().equals(currentLineLecture)) {
								java.io.File to = new java.io.File(mainView
										.getDestinyAddressText().getText()
										+ COMPARE + temp.getName());
								java.nio.file.Files.copy(temp.toPath(),
										to.toPath());
								countCopyFiles++;
								break;
							}
						}
						lectureFile.close();
					}
				}
				mainView.getGlobalStateLabel().setText(
						FILE_COUNT_HEAD + files.length + FILE_COUNT_TRAILER);

				if (foldersEmptyCreated) {
					javax.swing.JOptionPane.showMessageDialog(mainView,
							COPY_FILES_HEAD + emptyFiles + COPY_FILES_TRAILER
									+ EMPTY, INFORMATION,
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
					javax.swing.JOptionPane.showMessageDialog(mainView,
							COPY_FILES_HEAD + notEmptyFiles
									+ COPY_FILES_TRAILER + NOT_EMPTY,
							INFORMATION,
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
					javax.swing.JOptionPane.showMessageDialog(mainView,
							MAJOR_DATE_HEADER + majorEmissionDate
									+ MAJOR_DATE_CONTENT + majorShipmentDate
									+ MAJOR_DATE_TRAILER + equalDate + EQUAL_DATE_TRAILER, INFORMATION,
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
				}

				if (folderCompareCreated) {
					javax.swing.JOptionPane.showMessageDialog(mainView,
							COPY_FILES_HEAD + countCopyFiles
									+ COPY_FILES_TRAILER + COMPARE,
							INFORMATION,
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
				}
				if (foldersCenterCreated) {
					javax.swing.JOptionPane.showMessageDialog(mainView,
							COPY_FILES_HEAD + caboFiles + COPY_FILES_TRAILER
									+ CABO, INFORMATION,
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
					javax.swing.JOptionPane.showMessageDialog(mainView,
							COPY_FILES_HEAD + sumareFiles + COPY_FILES_TRAILER
									+ SUMARE, INFORMATION,
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
					javax.swing.JOptionPane.showMessageDialog(mainView,
							COPY_FILES_HEAD + descartableFiles
									+ COPY_FILES_TRAILER + DESCARTABLE,
							INFORMATION,
							javax.swing.JOptionPane.INFORMATION_MESSAGE);
				}
				checkConditions();
			} catch (IOException | HeadlessException ex) {
				javax.swing.JOptionPane.showMessageDialog(mainView,
						UNEXPECTED_ERROR, ERROR,
						javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private boolean loadFiles() {
		boolean result = false;
		folder = new java.io.File(mainView.getFRDNEAddressText().getText());
		if (folder.exists()) {
			files = folder.listFiles();
			logs = new String[files.length];
			mainView.getGlobalStateLabel().setText(FILE_FOUND);
			result = true;
		} else {
			javax.swing.JOptionPane.showMessageDialog(mainView,
					UNEXISTED_FOLDER, ERROR,
					javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}

	private void constructLog(String name, String fiscalNote, String city,
			String state, String emission, String shipment, int files) {
		files = files - 1;
	}

	private boolean checkDescartability(java.io.File temp)
			throws FileNotFoundException, IOException {
		boolean descartable = false;
		String currentLine;
		java.io.BufferedReader buffRead = new java.io.BufferedReader(
				new java.io.FileReader(temp));
		while ((currentLine = buffRead.readLine()) != null) {
			if (currentLine.substring(
					entity.FRDNELayoutConstants.BEGIN_REGISTER,
					entity.FRDNELayoutConstants.END_REGISTER).equals(
					entity.FRDNELayoutConstants.BUSSINESS_PARTNERS)) {
				for (String tempString : entity.ClasificationConstants.DESCARTABLE_CRITERIA) {
					if (currentLine.contains(tempString)) {
						java.io.File to = new java.io.File(mainView
								.getDestinyAddressText().getText()
								+ DESCARTABLE + temp.getName());
						java.nio.file.Files.copy(temp.toPath(), to.toPath());
						descartable = true;
					}
				}
				break;
			}
		}
		buffRead.close();
		return descartable;
	}

	private boolean createCenterFolders() {
		boolean success = (new java.io.File(mainView.getDestinyAddressText()
				.getText() + CABO).mkdirs());
		boolean success1 = (new java.io.File(mainView.getDestinyAddressText()
				.getText() + SUMARE).mkdirs());
		boolean success2 = ((new java.io.File(mainView.getDestinyAddressText()
				.getText() + DESCARTABLE).mkdirs()));
		return success && success1 && success2;
	}

	private boolean createCompareFolders() {
		boolean result = (new java.io.File(mainView.getDestinyAddressText()
				.getText() + COMPARE).mkdirs());
		return result;
	}

	private boolean createEmptyFolders() {
		boolean success = (new java.io.File(mainView.getDestinyAddressText()
				.getText() + EMPTY).mkdirs());
		boolean success1 = (new java.io.File(mainView.getDestinyAddressText()
				.getText() + NOT_EMPTY).mkdirs());
		boolean success2 = (new java.io.File(mainView.getDestinyAddressText()
				.getText() + EQUAL_DATA).mkdirs());
		boolean success3 = (new java.io.File(mainView.getDestinyAddressText()
				.getText() + MAJOR_EMISSION).mkdirs());
		boolean success4 = (new java.io.File(mainView.getDestinyAddressText()
				.getText() + MAJOR_SHIPMENT).mkdirs());
		return success && success1 && success2 && success3 && success4;
	}

	public void getReport() {

	}

	private final view.MainView mainView;
	private String logs[];
	private java.io.File folder;
	private java.io.File files[];
	
	private final String EQUAL_DATA = "\\Iguales\\";
	private final String MAJOR_EMISSION = "\\Emision\\";
	private final String MAJOR_SHIPMENT = "\\Embarque\\";
	private final String EMPTY = "\\Vacios\\";
	private final String NOT_EMPTY = "\\Llenos\\";
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
	private final String MAJOR_DATE_HEADER = "Se encontraron (";
	private final String MAJOR_DATE_CONTENT = ") con fecha de emisión mayor, (";
	private final String MAJOR_DATE_TRAILER = ") con fecha de embarque mayor y (";
	private final String EQUAL_DATE_TRAILER = ") con fecha igual.";
	private final String FRDNE = "FRDNE";
	private final String DESTINY = "DESTINY";
	private final String TXT = "TXT";
}
