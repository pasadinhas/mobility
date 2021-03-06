/*
 * @(#)JobOfferInformation.java
 *
 * Copyright 2010 Instituto Superior Tecnico
 * Founding Authors: Susana Fernandes
 * 
 *      https://fenix-ashes.ist.utl.pt/
 * 
 *   This file is part of the Internal Mobility Module.
 *
 *   The Internal Mobility Module is free software: you can
 *   redistribute it and/or modify it under the terms of the GNU Lesser General
 *   Public License as published by the Free Software Foundation, either version 
 *   3 of the License, or (at your option) any later version.
 *
 *   The Internal Mobility  Module is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with the Internal Mobility  Module. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package module.mobility.domain.activity;

import module.mobility.domain.JobOfferProcess;
import module.mobility.domain.util.JobOfferBean;
import module.workflow.activities.ActivityInformation;
import module.workflow.activities.WorkflowActivity;

/**
 * 
 * @author Susana Fernandes
 * 
 */
public class JobOfferInformation extends ActivityInformation<JobOfferProcess> {
    private JobOfferBean jobOfferBean;

    public JobOfferInformation(final JobOfferProcess jobOfferProcess,
            WorkflowActivity<JobOfferProcess, ? extends ActivityInformation<JobOfferProcess>> activity) {
        super(jobOfferProcess, activity);
        setJobOfferBean(new JobOfferBean(jobOfferProcess.getJobOffer()));
    }

    @Override
    public boolean hasAllneededInfo() {
        return getProcess().getJobOffer() != null && isForwardedFromInput();
    }

    public JobOfferBean getJobOfferBean() {
        return jobOfferBean;
    }

    public void setJobOfferBean(JobOfferBean jobOfferBean) {
        this.jobOfferBean = jobOfferBean;
    }

}
