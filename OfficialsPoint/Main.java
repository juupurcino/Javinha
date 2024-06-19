import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int quit = 0;

        Scanner scanner = new Scanner(System.in);

        ListOfficial listOfficial = new ListOfficial();
        ListPoint listPoint = new ListPoint();

        Official logged = null;

        System.out.println("======= CADASTRAR ADMINISTRADOR ========");
        System.out.print("Digite seu nome: ");
        String nomeAdmin = scanner.nextLine();
        System.out.print("Digite seu cpf: ");
        Long cpfAdmin = scanner.nextLong();
        System.out.print("Digite sua data de nascimento: ");
        int date_of_birthAdmin = scanner.nextInt();
        System.out.print("Digite sua senha: ");
        int passwordAdmin = scanner.nextInt();

        Official official = new Official(nomeAdmin, cpfAdmin, date_of_birthAdmin, passwordAdmin, true);

        System.out.println("======= LOGIN ========");
        System.out.print("Digite seu cpf: ");
        Long cpfChecks = scanner.nextLong();
        System.out.print("Digite sua senha: ");
        int passwordChecks = scanner.nextInt();

        while (quit == 0) {

            boolean isAdmin = false;
            int choice = 0;

            for (int i = 0; i < listOfficial.getSize(); i++) {
                Official currentOfficial = listOfficial.get(i);

                if (currentOfficial.getCpf().equals(cpfChecks) && currentOfficial.getPassword() == passwordChecks) {
                    logged = currentOfficial;
                    isAdmin = currentOfficial.isAdmin();
                    break;
                }
            }

            if (logged != null) {
                if (isAdmin) {
                    System.out.println("\n1. Cadastrar novo empregado\n2. Listar empregados\n3. Histórico\n4. Sair");
                    choice = scanner.nextInt();
                } else {
                    System.out.println("====== CADASTRAR PONTO ======");
                    System.out.println("Digite seu cpf: ");
                    Long cpffunc = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Dia: ");
                    int day = scanner.nextInt();

                    System.out.println("Mes: ");
                    int month = scanner.nextInt();

                    System.out.println("Ano: ");
                    int year = scanner.nextInt();

                    System.out.println("Digite a hora");
                    int hour = scanner.nextInt();

                    System.out.println("Digite o minuto: ");
                    int minute = scanner.nextInt();

                    Point point = new Point(logged, day, month, year, hour, minute);
                    listPoint.addPoint(point);
                }

                switch (choice) {
                    case 1:
                        System.out.print("Digite o nome do novo funcionario: ");
                        String newName = scanner.nextLine();

                        System.out.print("Digite o cpf do novo funcionario: ");
                        Long newCpf = scanner.nextLong();

                        System.out.print("Digite a data de nascimento do novo funcionario: ");
                        int newDate = scanner.nextInt();

                        System.out.print("Digite a senha do novo funcionario: ");
                        int newPassword = scanner.nextInt();

                        Official officialAdd = new Official(newName, newCpf, newDate, newPassword, false);
                        listOfficial.add(officialAdd);
                        break;

                    case 2:
                        for (int j = 0; j < listOfficial.getSize(); j++) {
                            Official printOut = listOfficial.get(j);
                            System.out.println("Nome: " + printOut.getName() + " | CPF: " + printOut.getCpf());
                        }
                        break;

                    case 3:
                        // Histórico de horas trabalhadas
                        break;

                    case 4:
                        quit = 1;
                        break;

                    default:
                        break;
                }
            
            } else {
                
                System.out.println("CPF ou senha incorretos. Tente novamente.");
                // Solicitar que o usuário insira novamente o CPF e a senha
                System.out.print("Digite seu CPF: ");
                cpfChecks = scanner.nextLong();
                System.out.print("Digite sua senha: ");
                passwordChecks = scanner.nextInt();
            }
        }
    }
}
