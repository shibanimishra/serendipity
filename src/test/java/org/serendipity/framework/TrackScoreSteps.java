package org.serendipity.framework;

import org.jbehave.core.annotations.*;
public class TrackScoreSteps {
	
	@Given("Alice has completed Poems and Stories activity")
	public void completedActivity(){
		System.out.println("hi");
	}
	@When("I submit her score for the activity")
	public void submitScore(){
		
	}

	@Then("I should see her score stored against the activity")
	public void shouldSeeScoresAgainstActivity(){
		
	}
}
