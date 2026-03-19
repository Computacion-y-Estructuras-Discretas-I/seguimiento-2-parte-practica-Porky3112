import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int na = sc.nextInt(), nb = sc.nextInt(), k = sc.nextInt();

        int[] servidorA = new int[na];
        for (int i = 0; i < na; i++) servidorA[i] = sc.nextInt();

        int[] servidorB = new int[nb];
        for (int i = 0; i < nb; i++) servidorB[i] = sc.nextInt();

        int[] baneados = new int[k];
        for (int i = 0; i < k; i++) baneados[i] = sc.nextInt();

        sc.close();

        TreeSet<Integer> activos = jugadoresActivos(servidorA, servidorB, baneados);

        System.out.println(activos.size());
        StringBuilder sb = new StringBuilder();
        for (int id : activos) sb.append(id).append(' ');
        System.out.println(sb.toString().trim());
    }


    public static TreeSet<Integer> jugadoresActivos(int[] servidorA,
                                                     int[] servidorB,
                                                     int[] baneados) {

        TreeSet<Integer> servidorAm = new TreeSet<>();
        TreeSet<Integer> servidorBm = new TreeSet<>();
        TreeSet<Integer> servidorBan = new TreeSet<>();

        for(int i = 0; i < servidorA.length; i++){

            servidorAm.add(servidorA[i]);
        }

        for(int i = 0; i < servidorB.length; i++){

            servidorBm.add(servidorB[i]);
        }

        for(int i = 0; i < baneados.length; i++){
            servidorBan.add(baneados[i]);
        }

        servidorAm.addAll(servidorBm);

        servidorAm.removeAll(servidorBan);

        return servidorAm;
    }
}