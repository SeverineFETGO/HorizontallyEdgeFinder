

import java.io.DataOutput;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println(java.time.LocalDate.now());
        System.out.println(java.time.LocalTime.now());
        float a,b,c,d,g,f, a1,b1,c1,n,e1,e2;
        int[] flag;
        flag=new int[3];

        a=b=c=d=g=f=a1=b1=c1=n=e2=0;


    	/*
    	RCPSPInstance data= new RCPSPInstance("Data/BL/bl20_1.rcp");
    	System.out.println("numberOfTasks= " + data.numberOfTasks + "		numberOfResources= " + data.numberOfResources);
    	for(int r=0; r<data.numberOfResources; r++)
    	{
    		System.out.println("Capacity"+r+ "="+ data.capacities[r]);
    	}
    	for(int i=0; i<data.numberOfTasks; i++)
    	{
    		System.out.println("processingTimes_"+i+ " = "+ data.processingTimes[i]);
    	}*/





        /*
         * Configuration for the pack & pack_d instances
         *
         */
     /*
        String fileName;
        runRCPSP sample1;
        String dir = "Data/PACK/";
        String chemin = "Data/RésultatBL201New.txt";
        File fiche =new File(chemin);
        for (int j=0; j<2; j++) {
            try {
                 a=b=c=d=g=f=a1=b1=c1=n=e2=0;
                // Création du fichier
                fiche.createNewFile();
                // creation d'un writer
                final FileWriter writer = new FileWriter(fiche, true);
                writer.write(java.time.LocalDate.now() + "\n " + java.time.LocalTime.now() + "\n");
                writer.write(dir + "\n" );
                System.out.println(dir);
                if (j == 0) {
                    writer.write(" BRANCHEMENT STATIQUE  \n ");
                    System.out.println(" BRANCHEMENT STATIQUE ");
                } else {
                    writer.write(" BRANCHEMENT DYNAMIQUE  \n ");
                    System.out.println(" BRANCHEMENT DYNAMIQUE ");
                }

                writer.write("Inst |" + "old_time |" + "old_backt |" + "makespan |" + "old_prop |" + "new_time |" + "new_backt |" + "makespan |" + "new_prop|"+ "\n");

                try {
                    for(int i = 1; i<= 55; i++) {
                        String name ="";
                        if(i < 10) {
                            fileName = dir + "pack00" + i + ".rcp";
                            name += "pack00" + i;

                        }else {
                            fileName = dir + "pack0" + i + ".rcp";
                            name += "pack0" + i;
                        }
                        writer.write(name  + " | ");
                        System.out.print(name  + " | ");

                        for (int prop = 0; prop < 2; prop++) {
                            flag[prop]=0;
                            sample1 = new runRCPSP(fileName, prop, j);
                            writer.write(+sample1.howMuchTime() + " | " + sample1.howManyBacktracks() + " | " + sample1.makeSpanSolution() + " | " + sample1.howManyAdjustments() + " | ");
                            System.out.print(+sample1.howMuchTime() + " | " + sample1.howManyBacktracks() + " | " + sample1.makeSpanSolution() + " | " + sample1.howManyAdjustments() + " | ");
                            // writer.write(name + " \n");
                            flag[prop]=sample1.makeSpanSolution();
                            if(prop==0 && flag[prop]!=-1)
                            {
                                a1=sample1.howMuchTime();
                                b1=sample1.howManyBacktracks();
                                c1=sample1.howManyAdjustments();
                            }
                            else if(prop==1 && flag[0]!=-1 && flag[1]!=-1)
                            {
                                n++;
                                a+=a1;
                                b+=b1;
                                c+=c1;
                                d+=sample1.howMuchTime();
                                g+=sample1.howManyBacktracks();
                                f+=sample1.howManyAdjustments();
                                e1=sample1.howManyBacktracks();
                                if(b1>e1)e2++;
                            }
                        }
                        writer.write( " \n");
                        System.out.println("");

                    }
                    writer.write("AVERAGE |" +a/n + " | " + b/n + " | " + c/n + " | " +d/n + " | " + g/n + " | " + f/n + " | " + " \n");
                    writer.write("TIME RATIO  = " + a/d*100 + " backtracks= " +e2);
                    System.out.println("AVERAGE |" +a/n + " | " + b/n + " | " + c/n + " | " +d/n + " | " + g/n + " | " + f/n + " | ");
                    System.out.println("TIME RATIO  = " + a/d*100 + "  backtracks= " +e2  + "  The number of instances solved by the 2 prop: " +n);
                } finally {
                    // quoiqu'il arrive, on ferme le fichier
                    writer.close();
                }

            } catch (Exception e) {

                System.out.println("Impossible de créer le fichier");
            }
        }
     */




        /*
         * Configuration for the BL20 & BL25  instances
         *
         */

//     /*
        String fileName;
        runRCPSP sample1;
        String dir = "Data/BL/";
        String chemin = "Data/RésutatsNouveaux.txt";
        File fiche =new File(chemin);
        for (int j=0; j<2; j++) {
            try {

                // Création du fichier
                fiche.createNewFile();
                // creation d'un writer
                final FileWriter writer = new FileWriter(fiche, true);
                writer.write("\n"+ java.time.LocalDate.now() + "\n " + java.time.LocalTime.now() + "\n");
                writer.write(dir + "\n");
                System.out.println("\n"+ dir);
                writer.write(" NOUVELLE VERSION  \n ");
                if (j == 0) {
                    writer.write(" BRANCHEMENT STATIQUE  \n ");
                    System.out.println(" BRANCHEMENT STATIQUE ");
                } else {
                    writer.write(" BRANCHEMENT DYNAMIQUE  \n ");
                    System.out.println(" BRANCHEMENT DYNAMIQUE ");
                }

                writer.write("Inst |" + "old_time |" + "old_backt |" + "makespan |" + "old_prop |" + "new_time |" + "new_backt |" + "makespan |" + "new_prop|"+ "\n");

                try {
                    for (int i = 1; i <= 20; i++) {
                        fileName = dir + "bl25_" + i + ".rcp";
                        //fileName = dir + "bl25_14.rcp";
                        String name = "bl_25_" + i;
                        writer.write(name  + " | ");
                        System.out.print(name  + " | ");

                        for (int prop = 0; prop <2; prop++) {
                            flag[prop]=0;
                            sample1 = new runRCPSP(fileName, prop, j);
                            writer.write(+sample1.howMuchTime() + " | " + sample1.howManyBacktracks() + " | " + sample1.makeSpanSolution() + " | " + sample1.howManyAdjustments() + " | ");
                            System.out.print(+sample1.howMuchTime() + " | " + sample1.howManyBacktracks() + " | " + sample1.makeSpanSolution() + " | " + sample1.howManyAdjustments() + " | ");
                            // writer.write(name + " \n");
                            flag[prop]=sample1.makeSpanSolution();
                        if(prop==1 && flag[prop]!=-1)
                        {
                            a1=sample1.howMuchTime();
                            b1=sample1.howManyBacktracks();
                            c1=sample1.howManyAdjustments();
                        }
                        else if(prop==2 && flag[prop-1]!=-1 && flag[prop]!=-1)
                            {
                                n++;
                                a+=a1;
                                b+=b1;
                                c+=c1;
                                d+=sample1.howMuchTime();
                                g+=sample1.howManyBacktracks();
                                f+=sample1.howManyAdjustments();
                                e1=sample1.howManyBacktracks();
                                if(b1>e1)e2++;
                            }
                        }
                        writer.write( " \n");
                        System.out.println("");

                    }
                        writer.write("AVERAGE |" +a/n + " | " + b/n + " | " + c/n + " | " +d/n + " | " + g/n + " | " + f/n + " | " + " \n");
                    writer.write("TIME RATIO  = " + a/d*100 + " backtracks= " +e2);
                    System.out.println("AVERAGE |" +a/n + " | " + b/n + " | " + c/n + " | " +d/n + " | " + g/n + " | " + f/n + " | ");
                    System.out.println("  TIME RATIO  = " + a/d*100+ " backtracks= " +e2  + "  The number of instances solved by the 2 prop: " +n);
                   // System.out.println(" terminé " );
                 } finally {
                    // quoiqu'il arrive, on ferme le fichier
                    writer.close();
                }

            } catch (Exception e) {

                System.out.println("Impossible de créer le fichier");
            }
        }
  // */


        /*
         * Configuration for J30, J60, J90, J120 & KSD15(called instance name J30)instances
         *
         */

   /*
       String fileName;
        runRCPSP sample1;
        String chemin = "Data/RésultatNEW.txt";
        File fiche = new File(chemin);
        String dir = "Data/J30/";
        for (int l = 0; l < 2; l++) {
            try {
                 a=b=c=d=g=f=a1=b1=c1=n=e2=0;
                // Creation du fichier
                fiche.createNewFile();
                // creation d'un writer
                final FileWriter writer = new FileWriter(fiche, true);
                writer.write(java.time.LocalDate.now() + "\n " + java.time.LocalTime.now() + "\n");
                writer.write("\n"+ dir + " \n ");
                System.out.println(dir);
                if (l == 0) {
                    writer.write(" BRANCHEMENT STATIQUE \n");
                    System.out.println(" BRANCHEMENT STATIQUE \n ");
                } else {
                    writer.write(" BRANCHEMENT DYNAMIQUE  \n ");
                    System.out.println(" BRANCHEMENT DYNAMIQUE ");
                }
                writer.write("Inst |" + "old_time |" + "old_backt |" + "makespan |" + "old_prop |" + "new_time |" + "new_backt |" + "makespan |" + "new_prop|  \n");

                try {
                    for (int K = 1; K <= 48; K++) {
                        for (int j = 1; j <= 10; j++) {
                            fileName = dir + "j30_" + K + "_" + j + ".rcp";
                            String name = "j30_" + K + "_" + j;
                            writer.write(name + ".rcp" + " | ");
                            System.out.print(name + ".rcp" + " | ");
                            for (int prop = 0; prop < 2; prop++) {
                                sample1 = new runRCPSP(fileName, prop, l);
                                writer.write(+sample1.howMuchTime() + " | " + sample1.howManyBacktracks() + " | " + sample1.makeSpanSolution() + " | " + sample1.howManyAdjustments() + " | ");
                                System.out.print(+sample1.howMuchTime() + " | " + sample1.howManyBacktracks() + " | " + sample1.makeSpanSolution() + " | " + sample1.howManyAdjustments() + " | ");
                                flag[prop]=sample1.makeSpanSolution();
                                if(prop==0 && flag[prop]!=-1)
                                {
                                    a1=sample1.howMuchTime();
                                    b1=sample1.howManyBacktracks();
                                    c1=sample1.howManyAdjustments();
                                }
                                else if(prop==1 && flag[prop-1]!=-1 && flag[prop]!=-1)
                                {
                                    n++;
                                    a+=a1;
                                    b+=b1;
                                    c+=c1;
                                    d+=sample1.howMuchTime();
                                    g+=sample1.howManyBacktracks();
                                    f+=sample1.howManyAdjustments();
                                    e1=sample1.howManyBacktracks();
                                    if(b1>e1)e2++;
                                }

                            }
                            writer.write(" \n");
                            System.out.println("");
                        }
                    }
                    writer.write("AVERAGE |" +a/n + " | " + b/n + " | " + c/n + " | " +d/n + " | " + g/n + " | " + f/n + " | " + " \n");
                    writer.write("TIME RATIO  = " + a/d*100 + " backtracks= " +e2);
                    System.out.println("AVERAGE |" +a/n + " | " + b/n + " | " + c/n + " | " +d/n + " | " + g/n + " | " + f/n + " | ");
                    System.out.println("TIME RATIO  = " + a/d*100 + "  backtracks= " +e2 + "  The number of instances solved by the 2 prop: " +n);
                } finally {
                    // quoiqu'il arrive, on ferme le fichier
                    writer.close();
                }

            } catch (Exception e) {
                System.out.println("Impossible de creer le fichier");
            }
        }

       */








    }
}

