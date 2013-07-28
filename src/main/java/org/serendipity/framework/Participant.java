package org.serendipity.framework;

import java.util.HashSet;
import java.util.Set;

import org.serendipity.framework.persistence.ParticipantActivityDAO;

public class Participant {
	private String name;
	private Set<Activity> activities;

	public Participant(String name) {
		this.name = name;
		activities = new HashSet<Activity>();
	}

	public void participateIn(Activity activity) {
		activities.add(activity);
		
	}

	public void submitScore(Activity activity, int score) {
		ParticipantActivityDAO participantActivityDao = new ParticipantActivityDAO();
		ParticipantActivity participantActivity = participantActivityDao.findByParticipantAndActivity(this,activity);
		if(participantActivity == null){
			participantActivity = participantActivityDao.create(new ParticipantActivity(this,activity));
		}
		participantActivity.setScore(score);
		participantActivityDao.update(participantActivity);
	}

}
