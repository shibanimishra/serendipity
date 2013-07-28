package org.serendipity.framework;

import org.jbehave.core.annotations.*;

import static org.junit.Assert.*;
public class TrackScoreSteps {
	private static final int ALICE_STORIES_SCORE = 60;
	private static final int ALICE_POETRY_SCORE = 70;
	private final Participant alice = new Participant("Alice");
	private final Activity poetry = new Activity("Poetry");
	private final Activity storySession = new Activity("StorySession");
	
	@Given("Alice has completed Poems and Stories activity")
	public void completedActivity(){
		alice.participateIn(poetry);
		alice.participateIn(storySession);
	}
	@When("I submit her score for the activity")
	public void submitScore(){
		alice.submitScore(poetry,ALICE_POETRY_SCORE);
		alice.submitScore(storySession, ALICE_STORIES_SCORE);
	}

	@Then("I should see her score stored against the activity")
	public void shouldSeeScoresAgainstActivity(){
		assertEquals(ALICE_POETRY_SCORE, poetry.getScore(alice));
		assertEquals(ALICE_STORIES_SCORE, storySession.getScore(alice));
	}
}
