package it.sella.contrattualistica.implementation.api.xsd;

import it.sella.contrattualistica.implementation.api.contractcreation.BaseView;
import it.sella.contrattualistica.implementation.api.contractcreation.Busta10View;
import it.sella.contrattualistica.implementation.api.contractcreation.ConfigurationView;
import it.sella.contrattualistica.implementation.api.contractcreation.ContractInfoXmlConverter;
import it.sella.contrattualistica.implementation.api.contractcreation.ContractInput;
import it.sella.contrattualistica.implementation.api.contractcreation.ContractType;
import it.sella.contrattualistica.implementation.api.contractcreation.GeneraStampa;
import it.sella.contrattualistica.implementation.api.contractcreation.InformazioniView;
import it.sella.contrattualistica.implementation.api.contractcreation.InvestimentoView;
import it.sella.contrattualistica.implementation.api.contractcreation.ObjectFactory;

public class APIInvoker {

	public static void main(final String args[]) {
		final ObjectFactory factory = new ObjectFactory();
		final BaseView baseView = factory.createBaseView();
		baseView.setCtrId("545678A");
		baseView.setContractType(ContractType.COVER);
		baseView.setProductName("ContoCorrente");
		baseView.setProductXml("<PRODUCT>Sample</PRODUCT>");
		baseView.setSoggettoId(123932L);
		baseView.setTemplateName("CONT_PROD");
		baseView.setGeneraStampa(GeneraStampa.F);
		final ConfigurationView configurationView = factory.createConfigurationView();
		configurationView.setAColMctRequired(true);
		configurationView.setB10Required(true);
		configurationView.setDsfRequired(true);
		configurationView.setNgRequired(true);
		configurationView.setSecondCallRequired(true);
		final InvestimentoView investimentoView = factory.createInvestimentoView();
		investimentoView.setIdExternal("123459");
		investimentoView.setIdFunzione("657762");
		investimentoView.setIdOperazione("987665");
		final InformazioniView informazioniView = factory.createInformazioniView();
		informazioniView.setCreditiId("987765");
		informazioniView.setDocumentoCode("2434535");
		final Busta10View b10 = factory.createBusta10View();
		b10.setB10Cdr("1243453");
		b10.setB10Code("76E35345");
		b10.setB10NumeroConto("123243556HGHG6");
		b10.setB10OttoCifre("33434231");
		final ContractInput contractInput = factory.createContractInput();
		contractInput.setBaseView(baseView);
		contractInput.setConfigurationView(configurationView);
		contractInput.setInvestimentoView(investimentoView);
		contractInput.setInformazioniView(informazioniView);
		contractInput.setBusta10View(b10);
		try {
			//final IContractCreateService service = IContractCreateService.Factory.getContractCreateService();
			//service.createContract(contractInput);
			new ContractInfoXmlConverter().buildContractInput(contractInput);
		}  catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
