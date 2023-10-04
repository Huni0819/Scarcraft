package com.nhnacademy.starcraft;

import com.nhnacademy.starcraft.specie.Protoss;
import com.nhnacademy.starcraft.specie.Specie;
import com.nhnacademy.starcraft.specie.Terran;
import com.nhnacademy.starcraft.specie.Zerg;
import com.nhnacademy.starcraft.unit.Unit;
import java.util.Random;
import java.util.Scanner;


public class Game {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private Specie player;
    private Specie computer;


    public void start() {
        System.out.println("게임을 시작합니다.");

        System.out.println("당신이 플레이할 종족을 선택하세요.");
        selectTribe();

        System.out.println("랜덤으로 컴퓨터의 종족이 선택됩니다.");
        selectTribeCom();

        playGame();
        scanner.close();
    }

    private void playGame() {
        while (true) {
            printUnit();
            try {
                playerAttack();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }

            if(winnerCheck(player, computer)) {
                System.out.println("승리했습니다.");
                break;
            }

            while (true) {
                try {
                    computerAttack(random.nextInt(computer.getSize()), random.nextInt(player.getSize()));
                    break;
                } catch (IllegalArgumentException exception) {
                    System.out.println("컴퓨터가 공격 대상을 다시 지정합니다.");
                }
            }

            if(winnerCheck(computer, player)) {
                System.out.println("패배했습니다.");
                break;
            }
        }
    }

    /**
     * user2의 남은 유닛이 존재하지 않거나 user2의 유닛으로 user1의 유닛을 잡지 못할 경우를 확인하는 메서드 입니다.
     * @param user1
     * @param user2
     * @return
     */
    private boolean winnerCheck(Specie user1, Specie user2) {
        if (user2.getSize() == 0 || (user2.isUnitCheck() && !user1.isUnitCheck())) {
            return true;
        }

        return false;
    }

    /**
     * 컴퓨터가 플레이어의 유닛을 공격하는 메서드 입니다.
     */
    private void computerAttack(int attackUnit, int defenseUnit) {
        System.out.println("컴퓨터가 공격을 진행합니다.");
        Unit computerUnit = computer.get(attackUnit);
        Unit playerUnit = player.get(defenseUnit);
        System.out.println("공격 유닛 : " + computerUnit);
        System.out.println("방어 유닛 : " + playerUnit);

        computerUnit.attack(playerUnit);

        if (playerUnit.getDefensivePower() <= 0) {
            player.remove(defenseUnit);
        }
    }

    /**
     * 플레이어가 컴퓨터의 유닛을 공격하는 메서드 입니다.
     */
    private void playerAttack() {
        int attackUnit, defenseUnit;
        System.out.print("공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택하세요: ");
        attackUnit = scanner.nextInt();
        defenseUnit = scanner.nextInt();

        if (attackUnit < 0 || attackUnit > player.getSize() || defenseUnit < 0 || defenseUnit > computer.getSize()) {
            throw new IllegalArgumentException("대상 지정이 잘못되었습니다. 다시 선택해 주세요.");
        }

        Unit playerUnit = player.get(attackUnit);
        Unit computerUnit = computer.get(defenseUnit);

        playerUnit.attack(computerUnit);

        if (computerUnit.getDefensivePower() <= 0) {
            computer.remove(defenseUnit);
        }
    }

    /**
     * 유저와 컴퓨터의 남은 유닛들의 상태를 출력하기 위한 메서드 입니다.
     */
    private void printUnit() {
        System.out.print("적군 : ");
        computer.printUnitList();
        System.out.println();
        System.out.print("아군 : ");
        player.printUnitList();
    }

    /**
     * 컴퓨터 종족 선택을 위한 메서드 입니다.
     */
    private void selectTribeCom() {
        int comNumber = random.nextInt(3) + 1;

        System.out.println(comNumber);

        if (comNumber == 1) {
            computer = new Terran();
        } else if (comNumber == 2) {
            computer = new Protoss();
        } else {
            computer = new Zerg();
        }

    }


    /**
     * 유저가 종족을 선택하는 메서드 입니다.
     */
    private void selectTribe() {
        int tribeNumber;
        System.out.println("==========");
        System.out.println("1. 테란");
        System.out.println("2. 프로토스");
        System.out.println("3. 저그");
        System.out.println("==========");

        tribeNumber = scanner.nextInt();

        if (tribeNumber == 1) {
            player = new Terran();
        } else if (tribeNumber == 2) {
            player = new Protoss();
        } else if (tribeNumber == 3) {
            player = new Zerg();
        } else {
            throw new IllegalArgumentException("selectTribe: 잘못된 종족 선택입니다.");
        }
    }

}
