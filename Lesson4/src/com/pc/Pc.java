package com.pc;

import java.util.Random;

public class Pc {
    private boolean canWork = true;
    private final Processor processor = new Processor();
    private final RAM ram = new RAM();
    private final HDD hdd = new HDD();
    private int countOn = 0;
    private int countOff = 0;
    private boolean statusWork = false;
    Random random = new Random();

    private boolean checkInput(int number) {
        int state = random.nextInt(2);
//        int state = 1;
        if (state == number) {
            System.out.println("/Check OK!");
            return true;
        } else {
            System.out.println("/Fail check - PC burned out");
            canWork = false;
            statusWork = false;
            return false;
        }
    }

    private boolean checkStatusWork() {
        if (statusWork) {
            System.out.println("/PC is ON");
        } else {
            System.out.println("/PC is OFF");
        }
        return statusWork;
    }

    private boolean checkCanWork() {
        if (canWork) {
            System.out.println("/PC is OK");
        } else {
            System.out.println("/Cant power ON broken PC");
        }
        return canWork;
    }

    public void ON(int number) {
        System.out.println("/Try Power ON");
        if (checkCanWork() && !checkStatusWork() && testComponents() && checkInput(number)) {
            statusWork = true;
            countOn++;
            System.out.println("/PC ON. Power ON - " + countOn + " time's");
        } else {
            System.out.println("/Cant ON");
        }
    }

    public void OFF(int number) {
        System.out.println("/Try Power OFF");
        if (checkStatusWork() && checkInput(number)) {
            countOff++;
            System.out.println("/PC OFF. Power OFF - " + countOff + " time's");
            statusWork = false;
        } else {
            System.out.println("/Cant OFF");
        }
    }

    private boolean testComponents() {
        return (processor.durabilityTest(countOn) & ram.durabilityTest(countOn) & hdd.durabilityTest(countOn));
    }

    class Processor {
        int durability = 1;

        boolean durabilityTest(int count) {
            if (durability <= count) {
                System.out.println("/Processor broken");
                return false;
            } else {
                return true;
            }
        }
    }

    class RAM {
        int durability = 1;

        boolean durabilityTest(int count) {
            if (durability <= count) {
                System.out.println("/RAM broken");
                return false;
            } else {
                return true;
            }
        }
    }

    class HDD {
        int durability = 1;

        boolean durabilityTest(int count) {
            if (durability <= count) {
                System.out.println("/HDD broken");
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean isStatusWork() {
        return statusWork;
    }
}
