package testfinance;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import finance.Banque;
import finance.Carte;
import finance.Distributeur;
import finance.IllegalCardUseException;
import finance.IllegalOperationException;
import finance.Session;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class SessionTestWithJMockit {
	
	private Session session;
	
	@Mocked
	Carte carte;	
	@Mocked
	Banque banque;
	@Mocked
	Distributeur distributeur;

	@Before
	public void setUp() throws Exception {
		session = new Session(banque, carte, distributeur, 1);
	}

	@Test
	public void sessionTest() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Constructor<Session> sessionConstructor = Session.class.getDeclaredConstructor(Banque.class,
													Carte.class,
													Distributeur.class,
													int.class
													);
		sessionConstructor.setAccessible(true);
		Session session = sessionConstructor.newInstance(banque, carte, distributeur, 0);
		
		Field fieldBanque = session.getClass().getDeclaredField("banque");
		Field fieldCarte = session.getClass().getDeclaredField("carte");
		Field fieldDistributeur = session.getClass().getDeclaredField("distributeur");
		Field fieldNumeroSession = session.getClass().getDeclaredField("numeroSession");
		Field fieldConnection = session.getClass().getDeclaredField("connecte");
		
		fieldBanque.setAccessible(true);
		fieldCarte.setAccessible(true);
		fieldDistributeur.setAccessible(true);
		fieldNumeroSession.setAccessible(true);
		fieldConnection.setAccessible(true);
		
		assertEquals(banque, fieldBanque.get(session));
		assertEquals(carte, fieldCarte.get(session));
		assertEquals(distributeur, fieldDistributeur.get(session));
		assertEquals(false, fieldConnection.get(session));
		assertEquals(0, fieldNumeroSession.get(session));
	}

	@Test
	public void startSessionTest() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		new Expectations() {{
			banque.authentifier(carte.getNumero(), carte.getCodeSecurite());
			result = true;
		}};
		
		Constructor<Session> sessionConstructor = Session.class.getDeclaredConstructor(Banque.class,
																						Carte.class,
																						Distributeur.class,
																						int.class
																						);
		sessionConstructor.setAccessible(true);
		Session session = sessionConstructor.newInstance(banque, carte, distributeur, 1);
		Field fieldConnection = session.getClass().getDeclaredField("connecte");
		fieldConnection.setAccessible(true);
		
		session.startSession();
		assertEquals(true, fieldConnection.get(session));
		
		new Verifications() {{
			banque.authentifier(anyLong, anyInt);
			maxTimes = 1;
		}};
	}

	@Test
	public void testValiderOperation() throws IllegalOperationException, IllegalCardUseException {
		new Expectations() {{
			distributeur.sendPin(1);
			result = 1234;
			carte.getPin();
			result = 1234;
			banque.autoriser(1, "retrait");
			result = true;
		}};
		
		session.validerOperation("retrait");
		
		new Verifications() {{
			distributeur.sendPin(anyInt);
			maxTimes = 1;
			banque.autoriser(anyInt, anyString);
			maxTimes = 1;
		}};
	}
	
	@Test(expected=IllegalOperationException.class)
	public void testValiderOperationInvalide() throws IllegalOperationException, IllegalCardUseException {
		new Expectations() {{
			distributeur.sendPin(1);
			result = 1234;
			carte.getPin();
			result = 1234;
			banque.autoriser(1, "retrait");
			result = false;
		}};
		
		session.validerOperation("retrait");
		
		new Verifications() {{
			distributeur.sendPin(anyInt);
			maxTimes = 1;
			banque.autoriser(anyInt, anyString);
			maxTimes = 1;
		}};
	}
	
	@Test(expected=IllegalCardUseException.class)
	public void testValiderOperationCarteInvalide() throws IllegalOperationException, IllegalCardUseException {
		new Expectations() {{
			distributeur.sendPin(1);
			result = 0000;
			carte.getPin();
			result = 1234;
		}};
		
		session.validerOperation("retrait");
		
		new Verifications() {{
			distributeur.sendPin(anyInt);
			maxTimes = 4;
			banque.autoriser(anyInt, anyString);
			maxTimes = 0;
		}};
	}
}

