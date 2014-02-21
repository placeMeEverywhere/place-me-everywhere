package com.placeMe.web.bean;

public abstract class AbstractWizardBean extends PlaceMeBean {
	
	protected boolean[] steps;

	public void init() {
		steps = new boolean[]{true,false,false,false,false};
	}
	
	public boolean[] getSteps() {
		return steps;
	}

	public void setSteps(boolean[] steps) {
		this.steps = steps;
	}
	
	public String startWizard(){
		init();
		return "insert-user/wizard";
	}

	public String goToStartWizard(){
		changeWizard(0);
		return "wizard";
	}
	
	public String goToProfile(){
		changeWizard(1);
		return "profile";
	}

	public String goToAddInfo(){
		changeWizard(2);
		return "add-info";
	}

	public String goToConfirm(){
		changeWizard(3);
		return "confirm";
	}

	public String goToThankYou(){
		changeWizard(4);
		return "thank-you";
	}
		
	private void changeWizard(int step) {
		for(int i=0; i<steps.length; i++){
			if(i==step)
				steps[i] = true;
			else
				steps[i] = false;
		}
	}

}
