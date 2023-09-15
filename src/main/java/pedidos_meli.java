import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pedidos_meli {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("*****WELCOME*****");

        String order = " ";
        String code = " ";
        String name = " ";
        String name_product = " ";
        String document = " ";
        String state = "";


        boolean aux = true;
        while (aux) {

            System.out.println("1. Registrar pedido: ");
            System.out.println("2. Gestionar pedidos: ");
            System.out.println("3. Gestionar ofertas: ");
            System.out.println("4. cosultar pedidos totales: ");
            System.out.println("5. Terminar");

            System.out.println("Ingrese un numero entre 1 - 5: ");
            int result = Integer.parseInt(scanner.nextLine());

            switch (result) {

                case 1:
                    System.out.println("Deseas registrar un pedido?: ");
                    order = scanner.nextLine();

                    while (order.equals("si")) {

                        System.out.print("Ingrese codigo del pedido: ");
                        code = scanner.nextLine();

                        System.out.println("Ingrese su nombre: ");
                        name = scanner.nextLine();

                        System.out.println("Ingrese nombre del producto: ");
                        name_product = scanner.nextLine();

                        System.out.print("Ingrese su documento: ");
                        document = scanner.nextLine();

                        System.out.print("Ingrese el estado del pedido: ");
                        state = scanner.nextLine();

                        pedido pedido = new pedido(code, name, name_product, document, state);

                        List<pedido> listapedidos = new ArrayList<>();

                        listapedidos.add(pedido);

                        Insert (listapedidos);

                        System.out.println("Deseas agregar otro pedido?:  ");
                        order = scanner.nextLine();

                    }
                    break;

                case 2:
                    System.out.print("Ingrese codigo del pedido: ");
                    code = scanner.nextLine();

                    System.out.println("Actualice su nombre: ");
                    name = scanner.nextLine();

                    System.out.print("Actualice su documento: ");
                    document = scanner.nextLine();

                    System.out.print("Actualice estado del pedido: ");
                    state = scanner.nextLine();

                    Editar(code, name, document, state);

                    break;

                case 3:

                    System.out.println("Ingrese codigo de la oferta: ");
                    String code_offer = scanner.nextLine();

                    System.out.println("Actualice el nombre del producto en oferta: ");
                    name_product = scanner.nextLine();

                    System.out.println("Actualice descripcion de la oferta: ");
                    String description = scanner.nextLine();

                    System.out.println("Actualice el precio normal del producto: ");
                    String normal_price = scanner.nextLine();

                    System.out.println("Actualice el precio en oferta del producto: ");
                    String offer_price = scanner.nextLine();

                    Editar_oferta(code_offer, name_product, description, normal_price, offer_price);

                    break;

                case 4:
                    System.out.println("Estos son los pedidos totales: ");

                    Select();

                    break;

                case 5:
                    System.out.println("Finalizando...");

                    aux = false;

                    break;

                default:
                    System.out.println("Ingrese un numero valido");


            }
        }
    }

    private static void Editar(String code, String name, String document, String state) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/pedidos";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consulta = "UPDATE gestion_pedidos SET nombre = ?, documento = ?, estado = ? WHERE codigo = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, document);
        preparedStatement.setString(3, state);
        preparedStatement.setString(4, code);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Pedido actualizado exitosamente");
        } else {
            System.out.println("No se encontró el pedido para actualizar");
        }

        preparedStatement.close();
        connection2.close();
    }

    private static void Editar_oferta (String code_offer, String name_product, String description, String normal_price, String offer_price) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/pedidos";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consulta = "UPDATE gestion_ofertas SET nombre = ?, descripcion = ?, precio_normal = ?, precio_oferta = ? WHERE codigo_oferta = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);
        preparedStatement.setString(1, name_product);
        preparedStatement.setString(2, description);
        preparedStatement.setString(3, normal_price);
        preparedStatement.setString(4, offer_price);
        preparedStatement.setString(5, code_offer);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Pedido actualizado exitosamente");
        } else {
            System.out.println("No se encontró el pedido para actualizar");
        }

        preparedStatement.close();
        connection2.close();
    }

    private static void Select() throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/pedidos";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM gestion_pedidos");

        while (resultSet2.next()) {
            String codigo = resultSet2.getString("codigo");
            String nombre = resultSet2.getString("nombre");
            String nombre_producto = resultSet2.getString("nombre_producto");
            String documento = resultSet2.getString("documento");
            String estado = resultSet2.getString("estado");

            System.out.println("Este es el codigo: " + codigo + " Nombre: " + nombre + " nombre producto: " + nombre_producto + " documento: " + documento + " estado: " + estado);
        }
    }

    private static void Insert(List<pedido> listapedidos) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/pedidos";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM gestion_pedidos");


            // Sentencia INSERT
            String sql = "INSERT INTO gestion_pedidos (codigo, nombre, nombre_producto, documento, estado) VALUES (?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, listapedidos.get(0).getCode());
            preparedStatement.setString(2, listapedidos.get(0).getName());
            preparedStatement.setString(3, listapedidos.get(0).getName_product());
            preparedStatement.setString(4, listapedidos.get(0).getDocument());
            preparedStatement.setString(5, listapedidos.get(0).getState());

            // Ejecutar la sentencia
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("producto agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar el producto.");
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

