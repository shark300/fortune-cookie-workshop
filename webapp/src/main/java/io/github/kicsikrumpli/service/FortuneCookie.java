package io.github.kicsikrumpli.service;

public class FortuneCookie {
	private Fortune fortune;
	private Lesson lesson;
	private Lotto lotto;

	public Fortune getFortune() {
		return fortune;
	}
	public void setFortune(Fortune fortune) {
		this.fortune = fortune;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	public Lotto getLotto() {
		return lotto;
	}
	public void setLotto(Lotto lotto) {
		this.lotto = lotto;
	}

}
