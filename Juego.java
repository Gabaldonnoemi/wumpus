import java.util.Random;
import java.util.Scanner;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////                                          INSTRUCCIONES										
///// 											---------------
/////	 El objetivo del juego es encontrar el oro escondido y salir por la casilla de salida[0][0] sin caer en un pozo 
/////	 o encontrar al wumpus. El tablero del juego que verá el usuario es un tablero 4x4, en el que irá viendo su posición 
/////	 en cada movimiento.
/////                            ATRÁS
/////					[0 0] [0 1] [0 2] [0 3]
/////		IZQUIERDA	[1 0] [1 1] [1 2] [1 3]   DERECHA
/////					[2 0] [2 1] [2 2] [2 3]
/////					[3 0] [3 1] [3 2] [3 3] 
/////							ADELANTE
/////
/////	 Los pozos son avisados con percibiendo una brisa en las casillas de su alrededor, al igual que el wumpus que será avisado 
/////    percibiendo su hedor en las casillas de su alrededor.
/////    Una vez comienze el juego, el usuario podrá decidir en un menu sus acciones:
/////	 - Pulsando "1" avanzará hacia adelante.
/////    - Pulsando "2" avanzará hacia atrás.
/////	 - Pulsando "3" avanzará hacia la derecha.
/////    - Pulsando "4" avanzará hacia la izquierda.
/////    - Pulsando "5" lanzara una flecha para matar al wumpus en las direcciones adelante, atrás, derecha o izquierda desde su posición.
/////	   El jugador posee 3 flechas, si pulsa "1" lanzara hacia adelante.
/////	 - Pulsando "6" podrá salir del tablero sólo si posee el oro y se encuentra en la casilla de salida.
/////   
/////     El jugador ganará el juego si consigue el oro y llega a la casilla[0][0], y pulsa la opción salir.
/////     El jugador perderá el juego si cae en un pozo o si entra en la casilla del wumpus vivo.
/////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class Juego {

	private int wumpusX=0;
	private int wumpusY=0;
	private int oroX=0;
	private int oroY=0;
	private static int flecha=3;
	static boolean running =true;
	Juego [][] tablero;

	
	public static void main(String[] args) {
		
	Scanner in=new Scanner (System.in);
    Juego a= new Juego();
    
	System.out.println("Comenzamos el juego");
	System.out.println(".....................................");
	int x1 = 0;
	int y1 = 0;
	
	Random rand= new Random();
	Juego [][] tablero;
	
	
	int wumpusX=0;
	int wumpusY=0;
	int oroX=0;
	int oroY=0;
	int oro=0;

	

	//Crear tablero
	tablero= new Juego[4][4];
	for(int i=0; i<4; i++) {
		for(int j=0; j<4; j++) {
			tablero[i][j]= new Juego();
		}
		}

	//Colocar el oro de manera aleatoria
	oroX= rand.nextInt(4);
	oroY= rand.nextInt(4);
	 while (oroX==0 && oroY==0 )
	 {
		 oroX= rand.nextInt(4);
		 oroY= rand.nextInt(4);
	 }
	//System.out.println("\nEl oro está colocado en : " + oroX + " , " + oroY);
	
	
	//Colocar el wumpus de manera aleatoria
	wumpusX= rand.nextInt(4);
	wumpusY= rand.nextInt(4);

	//No deben coincidir en la misma casilla el wumpus y el oro
	 while (wumpusX==oroX && wumpusY==oroY )
	 {
		 wumpusX= rand.nextInt(4);
		 wumpusY= rand.nextInt(4);
	 }
	 while (wumpusX==0 && wumpusY==0 )
	 {
		 wumpusX= rand.nextInt(4);
		 wumpusY= rand.nextInt(4);
	 }

	 //System.out.println("\nEl wumpus está colocado en : " + wumpusX + " , " + wumpusY);
	 

	 
	 //Colocar aleatoriamente los pozos
	  boolean pozo1=false;
	  boolean pozo2=false;
	  boolean pozo3=false;
	  
	  int pozoX=0;
	  int pozoY=0;
	  int pozo2X=0;
	  int pozo2Y=0;
	  int pozo3X=0;
	  int pozo3Y=0;
	  
	  
	  //COLOCAR EL POZO 1 DE FORMA ALEATORIA Y NO COINCIDIENDO CON EL ORO O WUMPUS
	  int pozox= rand.nextInt(4);
	  int pozoy= rand.nextInt(4);
	  
	  while(pozo1==false)
	  {
		  if(pozox!=0 || pozoy!=0) //El pozo no puede estar en la salida
		  {  
			  if(pozox!=oroX || pozoy!=oroY) //El pozo no puede estar en la posición del oro
			  { 
				  if(pozox!=wumpusX || pozoy!=wumpusY)
				  {
					  pozoX=pozox;
					  pozoY=pozoy;
					  //System.out.println("\nEl pozo 1 ha sido colocado " + pozoX + " , " + pozoY);
					  pozo1=true;
					 
				  }
			  }
		  }
	  }
		 
	  
			  
	
	  //COLOCAR EL POZO 2 DE FORMA ALEATORIA Y NO COINCIDIENDO CON EL ORO O WUMPUS  
	  pozox= rand.nextInt(4);
	  pozoy= rand.nextInt(4);
	  
	  
	  while(pozo2==false)
	  {
		  if(pozox!=0 || pozoy!=0) //El pozo no puede estar en la salida
		  {	  
			  if(pozox!=oroX || pozoy!=oroY) //El pozo no puede estar en la posición del oro
			  { 
				  if(pozox!=wumpusX || pozoy!=wumpusY)
				  {
				  pozo2X=pozox;
				  pozo2Y=pozoy;
				 // System.out.println("\nEl pozo 2 ha sido colocado " + pozo2X + " , " + pozo2Y);
				  pozo2=true;
				
				  
				  }
			  }
		  }
	  }
	  
	  //COLOCAR EL POZO 3 DE FORMA ALEATORIA Y NO COINCIDIENDO CON EL ORO O WUMPUS  
	  pozox= rand.nextInt(4);
	  pozoy= rand.nextInt(4);
	  
	  
	  while(pozo3==false)
	  {
		  if(pozox!=0 || pozoy!=0) //El pozo no puede estar en la salida
		  {  
			  if(pozox!=oroX || pozoy!=oroY) //El pozo no puede estar en la posición del oro
			  { 
				  if(pozox!=wumpusX || pozoy!=wumpusY)
				  {
					  pozo3X=pozox;
					  pozo3Y=pozoy;
					  //System.out.println("\nEl pozo 3 ha sido colocado " + pozo3X + " , " + pozo3Y);
					  pozo3=true;
					 
				  }
			  }
		  }
	  }
	  
     
						 
						  
	//Mostramos el tablero al usuario
	a.mostrarTablero(x1,y1);
	
	
	System.out.println("\nTe encuentras en la casilla [0,0]");
	
		while(running) // SE EJECUTA DE FORMA CONTINUA HASTA EL FIN DEL JUEGO
		{
			System.out.println("\n ¿Que deseas hacer?");
			System.out.println("\n 1. Avanzar hacia adelante ");
			System.out.println("\n 2. Retrodecer hacia atrás ");
			System.out.println("\n 3. Avanzar hacia la derecha ");
			System.out.println("\n 4. Avanzar hacia la izquierda ");
			System.out.println("\n 5. Lanzar flecha ");
			System.out.println("\n 6. Salir");
			
			
			String input = in.nextLine();
			
		
		
		    if(input.equals("1")) //Avanzar hacia adelante, mostramos posición en tablero y comprobamos casilla
		    {
		    	if(x1>=0 && x1<3)
		    	{
		    		x1++;
		    		System.out.println("\nHas avanzado una casilla hacia adelante");
		    		a.mostrarTablero(x1,y1);
		    		a.ComprobarCasillaWumpus(x1,y1,wumpusX, wumpusY);
					oro=a.ComprobarCasillaOro(x1, y1, oroX, oroY, oro);
					a.ComprobarPozo(x1, y1, pozoX,pozoY);
					a.ComprobarPozo(x1, y1, pozo2X,pozo2Y);
					a.ComprobarPozo(x1, y1, pozo3X,pozo3Y);
					a.ComprobarBrisa(x1, y1, pozoX, pozoY);
					a.ComprobarBrisa(x1, y1, pozo2X, pozo2Y);
					a.ComprobarBrisa(x1, y1, pozo3X, pozo3Y);
					a.ComprobarHedor(x1, y1, wumpusX, wumpusY);
		    	}
		    	else 
		    	{
		    		System.out.println("\nNo puedes avanzar una casilla hacia adelante");
		    	}
		    		
		    	}
		    
		    
		    else if(input.equals("2")) //Avanzar hacia atras, mostramos posición en tablero y comprobamos casilla
		    {
		    	if(x1<=3 && x1>0)
		    	{
		    		x1--;
		    		System.out.println("\nHas avanzado una casilla hacia atrás");
		    		a.mostrarTablero(x1,y1);
		    		a.ComprobarCasillaWumpus(x1,y1,wumpusX, wumpusY);
					oro=a.ComprobarCasillaOro(x1, y1, oroX, oroY, oro);
					a.ComprobarPozo(x1, y1, pozoX,pozoY);
					a.ComprobarPozo(x1, y1, pozo2X,pozo2Y);
					a.ComprobarPozo(x1, y1, pozo3X,pozo3Y);
					a.ComprobarBrisa(x1, y1, pozoX, pozoY);
					a.ComprobarBrisa(x1, y1, pozo2X, pozo2Y);
					a.ComprobarBrisa(x1, y1, pozo3X, pozo3Y);
					a.ComprobarHedor(x1, y1, wumpusX, wumpusY);
		    	}
		    	else 
		    	{
		    		System.out.println("\nNo puedes avanzar una casilla hacia atrás");
		    	}
		    	
		    }
		    
		    else if(input.equals("3")) //Avanzar hacia la derecha, mostramos posición en tablero y comprobamos casilla
		    {
		    	if(y1>=0 && y1<3)
		    	{
		    		y1++;
		    		System.out.println("\nHas avanzado una casilla a la derecha");
		    		a.mostrarTablero(x1,y1);
		    		a.ComprobarCasillaWumpus(x1,y1,wumpusX, wumpusY);
					oro=a.ComprobarCasillaOro(x1, y1, oroX, oroY, oro);
					a.ComprobarPozo(x1, y1, pozoX,pozoY);
					a.ComprobarPozo(x1, y1, pozo2X,pozo2Y);
					a.ComprobarPozo(x1, y1, pozo3X,pozo3Y);
					a.ComprobarBrisa(x1, y1, pozoX, pozoY);
					a.ComprobarBrisa(x1, y1, pozo2X, pozo2Y);
					a.ComprobarBrisa(x1, y1, pozo3X, pozo3Y);
					a.ComprobarHedor(x1, y1, wumpusX, wumpusY);
		    	}
		    	else 
		    	{
		    		System.out.println("\nNo puedes avanzar una casilla a la derecha");
		    	}
		    }
		    
		    else if(input.equals("4")) //Avanzar hacia la izquierda, mostramos posición en tablero y comprobamos casilla
		    {
		    	if(y1<=3 && y1>0)
		    	{
		    		y1--;
		    		System.out.println("\nHas avanzado una casilla a la izquierda");
		    		a.mostrarTablero(x1,y1);
		    		a.ComprobarCasillaWumpus(x1,y1,wumpusX, wumpusY);
					oro=a.ComprobarCasillaOro(x1, y1, oroX, oroY, oro);
					a.ComprobarPozo(x1, y1, pozoX,pozoY);
					a.ComprobarPozo(x1, y1, pozo2X,pozo2Y);
					a.ComprobarPozo(x1, y1, pozo3X,pozo3Y);
					a.ComprobarBrisa(x1, y1, pozoX, pozoY);
					a.ComprobarBrisa(x1, y1, pozo2X, pozo2Y);
					a.ComprobarBrisa(x1, y1, pozo3X, pozo3Y);
					a.ComprobarHedor(x1, y1, wumpusX, wumpusY);
		    		
		    	}
		    	else 
		    	{
		    		System.out.println("\nNo puedes avanzar una casilla a la izquierda");
		    	}
		    }
		    
		    else if(input.equals("5"))  //Lanzar flecha
		    {
		    	if(flecha==0)
		    	{
		    		System.out.println("\nNo dispones de más flechas");
		    	}
		    	LanzarFlecha(flecha, x1, y1, wumpusX,  wumpusY);
		    	if(flecha>0)
		    	{
		    	flecha--;
		    	System.out.println("\nTe quedan " + flecha + " flecha(s)");
		    	}
		    }
		    
		    else if(input.equals("6")) //Salir del tablero sólo si poseemos el oro
		    {
		    	if(x1==0 && y1==0)
		    	{
		    		if(oro==1)
		    		{
		    		System.out.println("\n¡¡Has salido vivo con el Oro!! ");
		    		System.out.println("\n¡¡ENHORABUENA!! ");
		    		System.out.println("\n¡¡HAS GANADO!! ");
		    		a.mostrarTablero(x1,y1);
		    		running=false;
		    		}
		    		else
		    		{
		    			System.out.println("\nNo puedes salir, no tienes el oro");
		    		}
		    	}
		    	else 
		    	{
		    		System.out.println("\nNo puedes salir, no te encuentras en la casilla de salida");
		    	}
		    }
		    
		    else  //Se ha introducido una opcion errónea
		    {
		    	System.out.println("\nInstrucción errónea");
		    }
	
	
		}
				
	} // fin main	
	

    ///////////////////////////////////////////////
	///////////////////--MÉTODOS--/////////////////
	//////////////////////////////////////////////
	
	
	
////////////////////////////--MOSTRAR TABLERO --/////////////////////

public void mostrarTablero(int posx, int posy)
{
	System.out.print("\n" );
	
	Juego[][] vistaTablero= new Juego[4][4];
	for(int i=0; i<4; i++)
	{
		for(int j=0; j<4; j++) 
		{
			if(i==posx && j==posy)
			{
				System.out.print("\t" +"[POS]" );
			}
			else
			{
				System.out.print("\t" +"[" + i  + " " + j + "]" );
			}
		}
		System.out.println();
	} 
}


////////////////////////////--COMPROBAR CASILLAS --/////////////////////	
	
	private void ComprobarCasillaWumpus(int x1, int y1, int Wx, int Wy) 
	{
		
		if(x1==Wx && y1==Wy )
		{
			System.out.println("\nEn esta casilla se encuentra un wumpus vivo... ¡¡HAS PERDIDO!!");
			System.out.println("\n...HAS PERDIDO..!!");
			this.running=false;
			
		}
	}
	
	
	
	private int ComprobarCasillaOro(int x1, int y1, int Ox, int Oy, int oro) 
	{
		if(x1==Ox && y1==Oy )
		{
			oro=1;
			System.out.println("\n¡¡¡ Has encontrado el oro !!!");
			System.out.println("\nDebes llegar a la casilla de salida sin encontrar el Wumpus");
		
			
		}
		return oro; //Devolverá oro=0 si no se ha encontrado el oro, y oro=1 si el oro ha sido encontrado
	
		
	}
	
	
	private void ComprobarPozo(int x1, int y1, int pozoX, int pozoY) 
	{
		if(x1==pozoX && y1==pozoY)
		{
			System.out.println("\n¡¡¡ Has caido en un pozo !!!");
			System.out.println("\n...HAS PERDIDO..!!");
			this.running=false;  //FIN JUEGO
		}	
	}
	

	
	private void ComprobarHedor(int x, int y, int wx, int wy)
	{
	    wx--;
	    if(wx>=0)
	    {
	    	if(x==wx && y==wy)
	    	{
	    		System.out.println("\n¡¡¡ El wumpus está cerca, puede percibirse su hedor!!!");
	    	}
	    	
	    }
	    wx=wx+2;
	    if(wx<=3)
	    {
	    	if(x==wx && y==wy)
	    	{
	    		System.out.println("\n¡¡¡ El wumpus está cerca, puede percibirse su hedor!!!");
	    	}
	    }
	    wx--;
	    wy--;
	    if(wy>=0)
	   {
	    	if(x==wx && y==wy)
	    	{
	    		System.out.println("\n¡¡¡ El wumpus está cerca, puede percibirse su hedor!!!");
	    	}
	   }
	   wy=wy+2;
	    if(wy<=3)
	    {
	    	if(x==wx && y==wy)
	    	{
	    		System.out.println("\n¡¡¡ El wumpus está cerca, puede percibirse su hedor!!!");
	    	}
	    }
	    wy--;
	  }
	
	
	private void ComprobarBrisa(int x, int y, int pozx, int pozy)
	{
	    pozx--;
	    if(pozx>=0)
	    {
	    	if(x==pozx && y==pozy)
	    	{  	
	    		System.out.println("\n¡¡¡ Hay un pozo cerca, puede percibirse su brisa!!!");
	    	}
	    	
	    }
	    pozx=pozx+2;
	    if(pozx<=3)
	    {
	    	if(x==pozx && y==pozy)
	    	{
	    		System.out.println("\n¡¡¡ Hay un pozo cerca, puede percibirse su brisa!!!");
	    	}
	    }
	    pozx--;
	    pozy--;
	    if(pozy>=0)
	   {
	    	if(x==pozx && y==pozy)
	    	{
	    		System.out.println("\n¡¡¡ Hay un pozo cerca, puede percibirse su brisa!!!");
	    	}
	   }
	   pozy=pozy+2;
	    if(pozy<=3)
	    {
	    	if(x==pozx && y==pozy)
	    	{
	    		System.out.println("\n¡¡¡ Hay un pozo cerca, puede percibirse su brisa!!!");
	    	}
	    }
	    pozy--;
	  }
	
	
	

////////////////////////////--LANZAR FLECHA --/////////////////////	

	
	private static void LanzarFlecha(int flecha, int x, int y, int wumpusX, int wumpusY)
	{
		if(flecha>0) {
	   
		Scanner in=new Scanner (System.in);
		
	    System.out.println("\n¿Hacia donde quieres mandar la flecha?");
	    System.out.println("\n 1. Adelante ");
		System.out.println("\n 2. Atrás ");
		System.out.println("\n 3. Derecha ");
		System.out.println("\n 4. Izquierda ");
	
		String input = in.nextLine();
		
		
		
	    if(input.equals("1")) //Lanzar hacia adelante
	    {
	      for(int i=x; i<4; i++)
	      {
	    	  if(i==wumpusX && y== wumpusY)
	    	  {
	    		  System.out.println("\n¡¡¡ Percibes un grito...!!!");
	    		  System.out.println("\n¡¡¡ Has matado al wumpus!!!");
	    		  wumpusX=-1; //Hacemos desaparecer al wumpus
	    		  wumpusY=-1;
	    	  }
	    	  else
	    	  {
	    		  System.out.println("\n¡¡¡ Tu flecha atraviesa la casilla sin resultados!!!");
	    	  }
	      
	      }
	      
	    }
	    
	    if(input.equals("2")) //Lanzar hacia atras
	    {
	    	for(int i=x; i>=0; i--)
		      {
		    	  if(i==wumpusX && y== wumpusY)
		    	  {
		    		  System.out.println("\n¡¡¡ Percibes un grito...!!!");
		    		  System.out.println("\n¡¡¡ Has matado al wumpus!!!");
		    		  wumpusX=-1;
		    		  wumpusY=-1;
		    	  }
		    	  else
		    	  {
		    		  System.out.println("\n¡¡¡ Tu flecha atraviesa la casilla sin resultados!!!");
		    	  }
		      
		      }
		      
		 }
	    
	    if(input.equals("3")) //Lanzar hacia la derecha
	    {
	    	for(int i=y; i<4; i++)
		      {
		    	  if(x==wumpusX && i== wumpusY)
		    	  {
		    		  System.out.println("\n¡¡¡ Percibes un grito...!!!");
		    		  System.out.println("\n¡¡¡ Has matado al wumpus!!!");
		    		  wumpusX=-1;
		    		  wumpusY=-1;
		    	  }
		    	  else
		    	  {
		    		  System.out.println("\n¡¡¡ Tu flecha atraviesa la casilla sin resultados!!!");
		    	  }
		      }
		  }
		     
		  
	    
	    if(input.equals("4")) //Lanzar hacia la izquierda
	    {
	    	for(int i=y; i<=0; i--)
		      {
		    	  if(x==wumpusX && i== wumpusY)
		    	  {
		    		  System.out.println("\n¡¡¡ Percibes un grito...!!!");
		    		  System.out.println("\n¡¡¡ Has matado al wumpus!!!"); 
		    		  wumpusX=-1;
		    		  wumpusY=-1;
		    	  }
		    	  else
		    	  {
		    		  System.out.println("\n¡¡¡ Tu flecha atraviesa la casilla sin resultados!!!");
		    	  }
		      }
		      
		    }
	    }
	}
	    
	   
		
}//Fin Main


