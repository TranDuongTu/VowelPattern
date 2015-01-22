package vn.elca.training.vowelpattern.controllers;

import vn.elca.training.vowelpattern.services.NLPService;

public abstract class Controller {
	
	protected NLPService nlpService;
	
	public NLPService getNlpService() {
		return nlpService;
	}

	public void setNlpService(NLPService nlpService) {
		this.nlpService = nlpService;
	}
}
