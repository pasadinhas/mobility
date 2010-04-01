package module.mobility.domain.activity;

import module.mobility.domain.PersonalPortfolio;
import module.mobility.domain.WorkerOffer;
import module.mobility.domain.WorkerOfferProcess;
import module.workflow.activities.ActivityInformation;
import module.workflow.activities.WorkflowActivity;
import myorg.domain.User;

public class EditWorkerJobOffer extends WorkflowActivity<WorkerOfferProcess, EditWorkerJobOfferInformation> {

    @Override
    public boolean isActive(final WorkerOfferProcess process, final User user) {
	final PersonalPortfolio personalPortfolio = process.getWorkerOffer().getPersonalPortfolio();
	return user == personalPortfolio.getPerson().getUser() && personalPortfolio.hasAnyPersonalPortfolioInfo();
    }

    @Override
    protected void process(final EditWorkerJobOfferInformation information) {
	final WorkerOffer workerOffer = information.getProcess().getWorkerOffer();
	workerOffer.setBeginDate(information.getBeginDate());
	workerOffer.setEndDate(information.getEndDate());
	workerOffer.setDisplayName(information.getDisplayName());
	workerOffer.setDisplayDateOfBirth(information.getDisplayDateOfBirth());
	workerOffer.setDisplayCarrer(information.getDisplayCarrer());
	workerOffer.setDisplayCategory(information.getDisplayCategory());
	workerOffer.setDisplaySalary(information.getDisplaySalary());
    }

    @Override
    public ActivityInformation<WorkerOfferProcess> getActivityInformation(final WorkerOfferProcess process) {
	return new EditWorkerJobOfferInformation(process, this);
    }

    @Override
    public String getUsedBundle() {
	return "resources/MobilityResources";
    }

}