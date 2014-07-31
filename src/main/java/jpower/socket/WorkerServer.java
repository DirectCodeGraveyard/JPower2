package jpower.socket;

import jpower.core.Service;
import jpower.core.WorkerPool;
import jpower.core.utils.ThreadUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class WorkerServer implements Service
{

    private final ServerSocket server;
    private final InetSocketAddress address;
    private final WorkerPool workerPool;
    private ClientHandler clientHandler;
    private Thread acceptThread;
    private boolean shouldRun;

    public WorkerServer(String host, int port) throws IOException
    {
        server = new ServerSocket();
        workerPool = new WorkerPool(30);
        address = new InetSocketAddress(host, port);
    }

    public void setClientHandler(ClientHandler clientHandler)
    {
        this.clientHandler = clientHandler;
    }

    @Override
    public boolean start()
    {
        shouldRun = true;
        try
        {
            server.bind(address);
        }
        catch (IOException e)
        {
            return false;
        }
        acceptThread = ThreadUtils.start(() -> {
            while (shouldRun)
            {
                workerPool.submit(() -> {
                    try
                    {
                        clientHandler.handleClient(new Client(server.accept()));
                    }
                    catch (IOException e)
                    {
                    }
                });
            }
        });
        return true;
    }

    @Override
    public boolean stop()
    {
        shouldRun = false;
        workerPool.waitForAll();
        return true;
    }

}
