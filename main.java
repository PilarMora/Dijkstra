public class Main {
  public static int distancia[] = new int[10];
  public static int costo[][] = new int[10][10];

  public static void main(String[] args) throws Exception {
    Main dij = new Main();

    /* Posiciones dentro del arreglo con valor de 100 */
    /* Indican que no hay conexion directa entre nodos */

    /* A */
    costo[1][1] = 100;	/* A */
    costo[1][2] = 3;		/* B */
    costo[1][3] = 100;	/* C */
    costo[1][4] = 100;	/* D */
    costo[1][5] = 100;	/* E */
    costo[1][6] = 2;		/* F */
    costo[1][7] = 100;	/* G */
    costo[1][8] = 100;	/* H */

    /* B */
    costo[2][1] = 3;		/* A */
    costo[2][2] = 100;	/* B */
    costo[2][3] = 2;		/* C */
    costo[2][4] = 3;		/* D */
    costo[2][5] = 3;		/* E */
    costo[2][6] = 100;	/* F */
    costo[2][7] = 100;	/* G */
    costo[2][8] = 100;	/* H */

    /* C */
    costo[3][1] = 100;	/* A */
    costo[3][2] = 2;		/* B */
    costo[3][3] = 100;	/* C */
    costo[3][4] = 100;	/* D */
    costo[3][5] = 4;		/* E */
    costo[3][6] = 100;	/* F */
    costo[3][7] = 100;	/* G */
    costo[3][8] = 5;		/* H */

    /* D */
    costo[4][1] = 100;	/* A */
    costo[4][2] = 3;		/* B */
    costo[4][3] = 100;	/* C */
    costo[4][4] = 100;	/* D */
    costo[4][5] = 2;		/* E */
    costo[4][6] = 5;		/* F */
    costo[4][7] = 100;	/* G */
    costo[4][8] = 100;	/* H */

    /* E */
    costo[5][1] = 100;	/* A */
    costo[5][2] = 3;		/* B */
    costo[5][3] = 4;		/* C */
    costo[5][4] = 2;		/* D */
    costo[5][5] = 100;	/* E */
    costo[5][6] = 100;	/* F */
    costo[5][7] = 2;		/* G */
    costo[5][8] = 100;	/* H */

    /* F */
    costo[6][1] = 2;		/* A */
    costo[6][2] = 100;	/* B */
    costo[6][3] = 100;	/* C */
    costo[6][4] = 5;		/* D */
    costo[6][5] = 100;	/* E */
    costo[6][6] = 100;	/* F */
    costo[6][7] = 1;		/* G */
    costo[6][8] = 100;	/* H */

    /* G */
    costo[7][1] = 100;	/* A */
    costo[7][2] = 100;	/* B */
    costo[7][3] = 100;	/* C */
    costo[7][4] = 100;	/* D */
    costo[7][5] = 2;		/* E */
    costo[7][6] = 1;		/* F */
    costo[7][7] = 100;	/* G */
    costo[7][8] = 5;		/* H */

    /* H */
    costo[8][1] = 100;	/* A */
    costo[8][2] = 100;	/* B */
    costo[8][3] = 5;		/* C */
    costo[8][4] = 100;	/* D */
    costo[8][5] = 100;	/* E */
    costo[8][6] = 100;	/* F */
    costo[8][7] = 5;		/* G */
    costo[8][8] = 100;	/* H */

    String consola = " \tA\tB\tC\tD\tE\tF\tG\tH\n";
    int nodos = 8;
    int c = 1;

    for (int i = 1; i <= nodos; i++) {
      consola += c++ + "\t";
      for (int j = 1; j <= nodos; j++) {
        if(costo[i][j] == 100) {
          consola += 0 + "\t";
        } else {
          consola += costo[i][j] + "\t";
        }
      }
      consola += "\n";
    }



    System.out.println(consola);

    int origen = 1;   /* A */
    int destino = 8;  /* H */


    dij.calcularRecorrido(nodos, origen);
    for (int i = 1; i <= nodos; i++) {
      if ( (i != origen) && (destino == i) ) {
        System.out.println("La ruta mas barata desde el origen: " + origen + "\t hasta el destino: " + i + "\t tiene un costo: " + dij.distancia[i]);
      }
    }

  }

  public void calcularRecorrido(int nodos, int origen) {
    int visitadoBand[] = new int[nodos + 1];
    int i, k, c = 2;

    for (i = 1; i <= nodos; i++) {
      visitadoBand[i] = 0;
      distancia[i] = costo[origen][i];
    }

    int estimacion, minpos = 1;
    while (c <= nodos) {
      estimacion = 87;

      for (k = 1; k <= nodos; k++) {
        if (distancia[k] < estimacion && visitadoBand[k] != 1) {
          estimacion = distancia[i];
          minpos = k;
        }
      }

      visitadoBand[minpos] = 1;
      c++;

      for (k = 1; k <= nodos; k++) {
        if (distancia[minpos] + costo[minpos][k] < distancia[k] && visitadoBand[k] != 1) {
          distancia[k] = distancia[minpos] + costo[minpos][k];
        }
      }
    }

  }

}