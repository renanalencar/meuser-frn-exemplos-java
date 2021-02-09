package com;
import java.util.Random;


public class adaline1 {
	
	private static double bias1[];
	
	private static double deltabs1[];

	private static double [][] pesos1;

	private static double [][] deltapesos1;
	private static double net1[];
	private static double erro1[][];
	private static double erro2[][];


	private static double fnet1[];

	private static double [][] entradas;

	private static double [][] saidas;


	//Atributo que indica o número de entradas.
	private static int numInputs;

	//Atributo que indica o número de saídas.
	private static int numOutputs;

	//Atributo que indica a quantidade de ciclos.
	private static int ciclos;

	//Atributo que indica a época atual.
	private static int cicloAtual;

	//Atributo que indica o número de treinamentos.
	private static int numTraining;

	//Atributo que indica o valor de Alfa (taxa de aprendizagem).
	private static double alfa;

	//Atributo que indica o valor de Momento(Momentum).
	private static double beta;
	
	//Atributo que indica o valor da semente do gerador de números aleatórios.
	private static long semente;


	/**
	 * Retorna o valor de semente
	 * @return
	 */
	public static long getSemente(){
		return semente;
	}

	/**
	 * Atribui o valor de semente.
	 * @param value
	 */
	public static void setSemente(long value){
		semente = value;
	}
	
	/**
	 * Retorna o valor de motum
	 * @return
	 */
	public static double getBeta(){
		return beta;
	}

	/**
	 * Atribui o valor de beta.
	 * @param value
	 */
	public static void setBeta(double value){
		beta = value;
	}

	/**
	 * Retorna o valor de alfa
	 * @return
	 */
	public static double getAlfa(){
		return alfa;
	}

	/**
	 * Atribui o valor de alfa.
	 * @param value
	 */
	public static void setAlfa(double value){
		alfa = value;
	}

	/**
	 * Retorna o número de exemplos de treinamento
	 * @return
	 */
	public static int getNumTraining(){
		return numTraining;
	}

	/**
	 * Atribui o número de exemplos de treinamento.
	 * @param value
	 */
	public static void setNumTraining(int value){
		numTraining = value;
	}

	/**
	 * Retorna o número de ciclos
	 * @return
	 */
	public static int getCiclos(){
		return ciclos;
	}

	/**
	 * Atribui o número de ciclos.
	 * @param value
	 */
	public static void setCiclos(int value){
		ciclos = value;
	}

	/**
	 * 
	 * 	/**
	 * Retorna  o ciclo atual
	 * @return
	 */
	public static int getCicloAtual(){
		return cicloAtual;
	}

	/**
	 * Atribui o número de épocas.
	 * @param value
	 */
	public static void setCicloAtual(int value){
		cicloAtual = value;
	}

	/**

	 * 
	 * Retorna o número de saídas.
	 * @return
	 */
	public static int getNumOutputs(){
		return numOutputs;
	}

	/**
	 * Atribui o número de saídas.
	 * @param value
	 */
	public static void setNumOutputs(int value){
		numOutputs = value;
		
		bias1 = new double[getNumOutputs()];
	    net1 = new double[getNumOutputs()];
		fnet1 = new double[getNumOutputs()];
		deltabs1 = new double [getNumOutputs()];
	}

	/**
	 * Retorna o número de entradas.
	 * @return
	 */
	public static int getNumInputs(){
		return numInputs;
	}

	/**
	 * Atribui o número de entradas.
	 * @param value
	 */
	public static void setNumInputs(int value){
		numInputs = value;

	}

	/**
	 * Atribui o valor do bias1 (limiar) no índice indicado.
	 * @param index: índice do vetor.
	 * @param value: valor que será atribuído.
	 */
	public static void setBias1(int index, double value){
		bias1[index]=value;
	}

	/**
	 * Retorna o valor do bias1 no índice indicado.
	 * @param index: índice do vetor.
	 */
	public static double getBias1(int index){
		return bias1[index];
	}

	/**
	 * Atribui o valor do net1 no índice indicado.
	 * @param index: índice do vetor.
	 * @param value: valor que será atribuído.
	 */
	public static void setNet1(int index, double value){
		net1[index]=value;
	}

	/**
	 * Retorna o valor do netin1 no índice indicado.
	 * @param index: índice do vetor.
	 */
	public static double getNet1(int index){
		return net1[index];
	}

	/**
	 * Retorna o valor do fnet1 no índice indicado.
	 * @param index: índice do vetor.
	 */
	public static double getFnet1(int index){
		return fnet1[index];
	}

	/**
	 * Atribui o valor do fnet1 no índice indicado.
	 * @param index: índice do vetor.
	 * @param value: valor que será atribuído.
	 */
	public static void setFnet1(int index, double value){
		fnet1[index]=value;
	}


	/**
	 * Atribui o valor do deltabs1 no índice indicado.
	 * @param index: índice do vetor.
	 * @param value: valor que será atribuído.
	 */
	public static void setDeltabs1(int index, double value){
		deltabs1[index]=value;
	}

	/**
	 * Retorna o valor do delbs1 no índice indicado.
	 * @param index: índice do vetor.
	 */
	public static double getDeltabs1(int index){
		return deltabs1[index];
	}

	/**
	 * Retorna o valor do Pesos1
	 * @return
	 */
	public static double getPesos1(int row, int col){
		return pesos1[row][col];
	}

	/**
	 * Atribui o valor de Pesos1.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setPesos1(int row, int col, double value){
		pesos1[row][col] = value;
	}

	/**
	 * Retorna o valor do Delwt1
	 * @return
	 */
	public static double getDeltapesos1(int row, int col){
		return deltapesos1[row][col];
	}

	/**
	 * Atribui o valor de Delwt1.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setDeltapesos1(int row, int col, double value){
		deltapesos1[row][col] = value;
	}

	/**
	 * Inicializa o valor da matriz Weight1.
	 * @param row
	 * @param col
	 */
	public static void initPesos1(int row, int col){
		pesos1 = new double[row][col];
	}



	/**
	 * Retorna o valor do Error1
	 * @return
	 */
	public static double getErro1(int row, int col){
		return erro1[row][col];
	}

	/**
	 * Atribui o valor de Error1.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setErro1(int row, int col, double value){
		erro1[row][col] = value;
	}


	/**
	 * Retorna o valor do error2
	 * @return
	 */
	public static double getErro2(int row, int col){
		return erro2[row][col];
	}

	/**
	 * Atribui o valor de error2.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setErro2(int row, int col, double value){
		erro2[row][col] = value;
	}


	/**
	 * Inicializa o valor da matriz Delwt1.
	 * @param row
	 * @param col
	 */
	public static void initDeltapesos1(int row, int col){
		deltapesos1 = new double[row][col];
	}

	/**
	 * Inicializa o valor da matriz Error1.
	 * @param row
	 * @param col
	 */
	public static void initErro1(int row, int col){
		erro1 = new double[row][col];
	}

	/**
	 * Inicializa o valor da matriz error2.
	 * @param row
	 * @param col
	 */
	public static void initErro2(int row, int col){
		erro2 = new double[row][col];
	}

	/**
	 * Retorna o valor da matriz de entrada.
	 * @param row
	 * @param col
	 */
	public static double getEntradas(int row, int col){
		return entradas[row][col];
	}

	/**
	 * Retorna o valor da matriz de saidas.
	 * @param row
	 * @param col
	 */
	public static double getSaidas(int row, int col){
		return saidas[row][col];
	}

	/**
	 * Inicialização dos pesos.
	 *
	 */
	public static void randomize(){

		//Cria uma instância de Random
		Random random = new Random(getSemente());

		for (int j=0; j<getNumOutputs(); j++) {
			//setBias1(j,-1+random.nextInt(8192)/8192);
			setBias1(j,0.0);			
			setDeltabs1(j, 0.0d);
			
			for (int i=0; i<getNumInputs(); i++) {
				//setPesos1(j, i, random.nextInt(8192)/8192-0.5d);
				setPesos1(j, i, 0.0);				
				setDeltapesos1(j, i, 0.0d);
			}
		}
		
		
	}

	
	public static void Forward () {
		for(int kl=0; kl<getCiclos(); kl++) {
			setCicloAtual(getCicloAtual()+ 1);
			for(int itr=0; itr<getNumTraining(); itr++) {

				double ea,eb;
				for (int j=0;j<getNumOutputs();j++) {
					setNet1(j, getBias1(j));
					for(int i=0;i<getNumInputs();i++){
						setNet1(j,getNet1(j)+ (getPesos1(j, i)* getEntradas(itr,i)));
					}

					ea= getNet1(j);
					
					setFnet1(j,(double) (ea));

				}


				for(int j=0;j<getNumOutputs();j++) {
					setErro2(itr,j, (getSaidas(itr,j) - getFnet1(j)));
					//impressão dos dados de saída
					System.out.println("Ciclo:"+ " "+ getCicloAtual() + "  "+	"Exemplo:" +" "+ (itr+1));

					System.out.println("Saída desejada:"+" "  +  getSaidas(itr,j)+ "  "+ "Saída calculada:" 
					+" " +getFnet1(j));
					System.out.println("Erro:" +" "+ getErro2(itr,j));

				}

				for(int j=0;j<getNumOutputs();j++) {
					setDeltabs1(j,( getAlfa() * getErro2(itr,j)));

					for(int ii=0;ii<getNumInputs();ii++) {
						setDeltapesos1(j,ii, (getAlfa() * getErro2(itr,j))*(getEntradas(itr,ii)));

					}
				}

				for(int j=0;j<getNumOutputs();j++) {
					setBias1(j, getDeltabs1(j) + getBias1(j));
					System.out.println("bias:"+" " + j +"     "+ getBias1(j)+ "  ");

					for(int ii=0;ii<getNumInputs();ii++) {

						setPesos1(j,ii, getPesos1(j,ii)+(getDeltapesos1(j,ii)));
						
						System.out.println("Peso:" +" "+ j+" " + ii + "    " +getPesos1(j,ii));

					}

				}

			}
		}
	}

	
	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args){
		
		//-----------------------------------------
		setSemente(13);
		setCiclos(3);
		setCicloAtual(0);
		setNumInputs(3);
		setNumOutputs(1);
		setNumTraining(6);
		setAlfa(0.5);
		setBeta(0.0);
		
		//-----------------------------------------
		
		//Inicializar o tamanho das matrizes.
		initPesos1(getNumOutputs(),getNumInputs());
		initDeltapesos1(getNumOutputs(),getNumInputs());
		

		initErro2(getNumTraining(), getNumOutputs());
		
		initErro1(getNumTraining(), getNumOutputs());

		//--------------------------------------------
		
		
		//Inicia os pesos aleatórios.
		randomize();

		double [][] entradasIniciais = {{0.3,0.1,0.1},
				{0.03,0.02,0.0},
				{1.0,1.0,1.0},
				{0.4,0.15,1.0},
				{0.9,0.80,0.8},
				{0.5,0.5,0.9}};

		entradas = entradasIniciais;

		//Inicializa os valores da matriz de saidas (4x1).
		double [][] saidasIniciais = {{0.19},
				{0.11},
				{0.60},
				{0.31},
				{0.52},
				{0.39}};


		saidas = saidasIniciais;
		
		Forward();

	}


}
