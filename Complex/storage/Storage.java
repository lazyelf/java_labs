package com.lazyelf.storage;

import com.lazyelf.storage.bouquetsComponents.Decoration;
import com.lazyelf.storage.bouquetsComponents.flowers.*;
import com.lazyelf.storage.bouquetsComponents.leaves.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Storage implements Serializable {
    private final ArrayList<Flower> flowers = new ArrayList<>();
    private final ArrayList<Leaf> leaves = new ArrayList<>();
    private final ArrayList<Bouquet> bouquets = new ArrayList<>();
    private final ArrayList<Decoration> decorations = new ArrayList<>();

    public static Comparator<Flower> FlowerLength = Comparator.comparingInt(Flower::getLength);
    public static Comparator<Flower> FlowerButtonSize = Comparator.comparingInt(Flower::getButtonSize);
    public static Comparator<Bouquet> BouquetPrice = Comparator.comparingDouble(Bouquet::getValue);

    public void cleanFlowers() {
        flowers.removeIf(Flower::checkVerdure);
        System.out.println("\tFlowers cleaned.");
    }

    public void addFlower() {
        System.out.print("\t\tChoose flower:\n"
                + "\t\t1 - Carnation\n"
                + "\t\t2 - Chamomile\n"
                + "\t\t3 - Chrysanthemum\n"
                + "\t\t4 - Orchid\n"
                + "\t\t5 - Peony\n"
                + "\t\t6 - Rose\n"
                + "\t\t7 - Tulip\n\t\t");
        Flower flower;
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                flower = new Carnation();
                break;
            case 2:
                flower = new Chamomile();
                break;
            case 3:
                flower = new Chrysanthemum();
                break;
            case 4:
                flower = new Orchid();
                break;
            case 5:
                flower = new Peony();
                break;
            case 6:
                flower = new Rose();
                break;
            case 7:
                flower = new Tulip();
                break;
            default:
                return;
        }
        flowers.add(flower);
    }

    public void sortFlowersByLength() {
        System.out.println("\t\tSorting list of flowers...");
        flowers.sort(FlowerLength);
    }

    public void sortFlowersByButtonSize() {
        System.out.println("\t\tSorting list of flowers...");
        flowers.sort(FlowerButtonSize);
    }

    public void showFlowers() {
        System.out.println("\t\tList of flowers:");
        if (flowers.size() > 0) {
            int i = 1;
            for (Flower f : flowers) {
                System.out.println("\t\t" + i + ". " + f.toString());
                ++i;
            }
        } else System.out.println("\t\tYou have no flowers.");
    }

    public void removeFlower(int order) {
        if (order > flowers.size() || order <= 0) {
            System.out.printf("\t\tFlower %d do not exists.\n", order);
            return;
        }
        flowers.remove(order - 1);
    }

    public void changeFlower(int order) {
        if (order > flowers.size() || order < 0) {
            System.out.printf("\t\tFlower %d do not exists.\n", order);
            return;
        }
        System.out.printf("\t\tChanging %d flower:\n", order);
        System.out.println("\t\t" + flowers.get(order - 1).toString());
        flowers.get(order - 1).changeFlower();
    }

    public void createBouquet() {
        System.out.println("\t\tCreating bouquet...");
        Scanner in = new Scanner(System.in);
        System.out.print("\t\tEnter bouquet name: ");
        Bouquet b = new Bouquet(in.nextLine());

        showFlowers();
        if (flowers.size() != 0) {
            System.out.print("\t\tEnter order of flowers that you want to add: ");
            String s = in.nextLine();
            Scanner str = new Scanner(s);
            int iteration = 0;
            while (str.hasNextInt()) {
                int i = str.nextInt() - iteration;
                if (i <= flowers.size() && i > 0) {
                    Flower f = flowers.get(i - 1);
                    b.addFlower(f);
                    ++iteration;
                }
                removeFlower(i);
            }
        }

        showLeaves();
        if (leaves.size() != 0) {
            System.out.print("\t\tEnter order of leaves that you want to add: ");
            String s = in.nextLine();
            Scanner str = new Scanner(s);
            int iteration = 0;
            while (str.hasNextInt()) {
                int i = str.nextInt() - iteration;
                if (i <= leaves.size() && i > 0) {
                    Leaf l = leaves.get(i - 1);
                    b.addLeaf(l);
                    ++iteration;
                }
                removeLeaf(i);
            }
        }

        showDecorations();
        if (decorations.size() != 0) {
            System.out.print("\t\tEnter order of decorations that you want to add: ");
            String s = in.nextLine();
            Scanner str = new Scanner(s);
            int iteration = 0;
            while (str.hasNextInt()) {
                int i = str.nextInt() - iteration;
                if (i <= decorations.size() && i > 0) {
                    Decoration d = decorations.get(i - 1);
                    b.addDecoration(d);
                    ++iteration;
                }
                removeDecoration(i);
            }
        }

        b.getValue();
        if (b.isNotEmpty())
            bouquets.add(b);
    }

    public void removeBouquet(int order) {
        if (order > bouquets.size() || order <= 0) {
            System.out.printf("\t\tBouquet %d do not exists.\n", order);
            return;
        }
        System.out.printf("\t\tRemoving %d bouquet from storage.\n", order);
        bouquets.remove(order - 1);
    }

    public void sortBouquets() {
        System.out.println("\t\t\tSorting list of bouquets...");
        bouquets.sort(BouquetPrice);
    }

    public void showBouquets() {
        System.out.println("\t\tList of bouquets:");
        if (bouquets.size() > 0) {
            int i = 1;
            for (Bouquet b : bouquets) {
                System.out.println("\t\t" + i + ". " + b.toString());
                ++i;
            }
        } else System.out.println("\t\tYou have no bouquets.");
    }

    public void changeBouquet(int order) {
        if (order > bouquets.size() || order <= 0) {
            System.out.printf("\t\tBouquet %d do not exists.\n", order);
            return;
        }
        System.out.println("\t\t" + bouquets.get(order - 1).toString());
        do {
            System.out.printf("\t\t----Changing %d bouquet---\n", order);
        }
        while (changeBouquetInhalant(order));
    }

    private boolean changeBouquetInhalant(int order) {
        System.out.print("\t\t\t1  - change flower\n"
                + "\t\t\t2  - remove flower\n"
                + "\t\t\t3  - add flower\n"
                + "\t\t\t4  - remove decorations\n"
                + "\t\t\t5  - add decoration\n"
                + "\t\t\t6  - remove leaf\n"
                + "\t\t\t7  - add leaf\n"
                + "\t\t\t8  - sort flowers by button size\n"
                + "\t\t\t9  - sort flowers by length\n"
                + "\t\t\t10 - find flower by length\n"
                + "\t\t\t11 - find flower by button size\n"
                + "\t\t\t12 - show bouquet that is in change process\n"
                + "\t\t\t13 - return\n\t\t\t");
        int add;
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                System.out.print("\t\tEnter order of flower to change: ");
                bouquets.get(order - 1).changeFlower(in.nextInt());
                break;
            case 2:
                System.out.print("\t\tEnter order of flower to remove: ");
                flowers.add(bouquets.get(order - 1).removeFlower(in.nextInt()));
                break;
            case 3:
                showFlowers();
                System.out.print("\t\tEnter order of flower to add: ");
                add = in.nextInt();
                Flower f = flowers.get(add - 1);
                bouquets.get(order - 1).addFlower(f);
                removeFlower(add);
                break;
            case 4:
                System.out.print("\t\tEnter order of decoration to remove: ");
                decorations.add(bouquets.get(order - 1).removeDecoration(in.nextInt()));
                break;
            case 5:
                showDecorations();
                System.out.print("\t\tEnter order of decorations to add: ");
                add = in.nextInt();
                Decoration d = decorations.get(add - 1);
                bouquets.get(order - 1).addDecoration(d);
                removeDecoration(add);
                break;
            case 6:
                System.out.print("\t\tEnter order of leaf to remove: ");
                leaves.add(bouquets.get(order - 1).removeLeaf(in.nextInt()));
                break;
            case 7:
                showLeaves();
                System.out.print("\t\tEnter order of leaf to add: ");
                add = in.nextInt();
                Leaf l = leaves.get(add - 1);
                bouquets.get(order - 1).addLeaf(l);
                removeLeaf(add);
                break;
            case 8:
                bouquets.get(order - 1).sortFlowersByButtonSize();
                break;
            case 9:
                bouquets.get(order - 1).sortFlowersByLength();
                break;
            case 10:
                bouquets.get(order - 1).findFlowerByLength();
                break;
            case 11:
                bouquets.get(order - 1).findFlowerByButtonSize();
                break;
            case 12:
                System.out.println("\t\t" + bouquets.get(order - 1).toString());
                break;
            default:
                return false;
        }
        bouquets.get(order - 1).getValue();
        return true;
    }

    public void addLeaf() {
        System.out.print("\t\tChoose leaf:\n"
                + "\t\t1 - Fern\n"
                + "\t\t2 - Lavender\n"
                + "\t\t3 - Palm\n"
                + "\t\t4 - Tree\n\t\t");
        Leaf leaf;
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                leaf = new Fern();
                break;
            case 2:
                leaf = new Lavender();
                break;
            case 3:
                leaf = new Palm();
                break;
            case 4:
                leaf = new Tree();
                break;
            default:
                return;
        }
        leaves.add(leaf);
    }

    public void removeLeaf(int order) {
        if (order > leaves.size() || order <= 0) {
            System.out.printf("\t\tLeaf %d do not exists.\n", order);
            return;
        }
        leaves.remove(order - 1);
    }

    public void showLeaves() {
        System.out.println("\t\tList of leaves:");
        if (leaves.size() > 0) {
            int i = 1;
            for (Leaf l : leaves) {
                System.out.println("\t\t" + i + ". " + l.toString());
                ++i;
            }
        } else System.out.println("\t\tYou have no leaves");
    }

    public void addDecoration() {
        System.out.println("\t\tAdding decoration...");
        decorations.add(new Decoration());
    }

    public void removeDecoration(int order) {
        if (order > decorations.size() || order <= 0) {
            System.out.printf("\t\tDecoration %d do not exists.\n", order);
            return;
        }
        decorations.remove(order - 1);
    }

    public void showDecorations() {
        System.out.println("\t\tList of decorations:");
        if (decorations.size() > 0) {
            int i = 1;
            for (Decoration d : decorations) {
                System.out.println("\t\t" + i + ". " + d.toString());
                ++i;
            }
        } else System.out.println("\t\tYou have no decorations.");
    }
}
