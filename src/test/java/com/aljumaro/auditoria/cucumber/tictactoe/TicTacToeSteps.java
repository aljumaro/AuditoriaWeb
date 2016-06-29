package com.aljumaro.auditoria.cucumber.tictactoe;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TicTacToeSteps {

	private static final String TOKEN = "x";
	private List<List<String>> board;

	@Given("^i have a board like this:$")
	public void iHaveABoardLikeThis(DataTable dt) {
		this.board = new ArrayList<List<String>>();
		for (List<String> row : dt.raw()) {
			this.board.add(new ArrayList<String>(row));
		}
	}

	@When("^i place a toke in row (\\d+) column (\\d+)$")
	public void iPlaceATokeInRowColumn(int row, int col) throws Throwable {
		board.get(row).set(col, TOKEN);

	}

	@Then("^the board should look like this:$")
	public void theBoardShouldLookLikeThis(DataTable dt) throws Throwable {
		dt.diff(board);
	}
}
