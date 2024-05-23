package com.example.computercommunicationgui2024;

import com.example.CommunicationData;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ServerController extends ClientServerController {

    public TextField serverIP;
    public TextField serverPort;

    public TableView<ClientConnection> clients;
    public TableColumn<ClientConnection, String> clientIPsColumn;
    public TableColumn<ClientConnection, String> nameColumn;

    public TableView<CommunicationData> allMessages;
    public TableColumn<CommunicationData, String> IPColumn;
    public TableColumn<CommunicationData, String> fromColumn;
    public TableColumn<CommunicationData, String> toColumn;
    public TableColumn<CommunicationData, String> messageColumn;

    static ServerSocketConnector connector;
    static Thread connectorThread;



    public void initialize() {
        clientIPsColumn.setCellValueFactory(new PropertyValueFactory<ClientConnection, String>("clientIP"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<ClientConnection, String>("name"));

        IPColumn.setCellValueFactory(new PropertyValueFactory<CommunicationData, String>("fromIPAddress"));
        fromColumn.setCellValueFactory(new PropertyValueFactory<CommunicationData, String>("from"));
        toColumn.setCellValueFactory(new PropertyValueFactory<CommunicationData, String>("to"));
        messageColumn.setCellValueFactory(new PropertyValueFactory<CommunicationData, String>("message"));

        connector = new ServerSocketConnector(this);
        connectorThread = new Thread(connector);
        connectorThread.start();
    }

}