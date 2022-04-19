package test;
import data.question.QCM;
import data.question.RC;
import data.question.VF;

public class testQuestion {

	public static void main(String[] args) {
		QCM q = new QCM("Ou est paris ?",2,"Italie","Espagne","Angleterre","France");
		RC r = new RC("Quel est la capitale de la France ?",1,"Paris");
		VF v = new VF("Paris est en France ?",1, true);
		System.out.println(q);
		System.out.println(r);
		System.out.println(v);
		System.out.println(q.getIndiceReponse());
		System.out.println(q.poserQuestion());
		System.out.println(q.poserQuestion());
	}

}
