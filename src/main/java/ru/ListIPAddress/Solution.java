package ru.ListIPAddress;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Solution {
    public  static void  main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ipStartPosition = reader.readLine();
        String ipEndPosition = reader.readLine();

        ArrayList<String> list_ip = new ArrayList<String>();

        InetAddress ip_start = InetAddress.getByName(ipStartPosition);
        InetAddress ip_end = InetAddress.getByName(ipEndPosition);


        int[] ip_int_st = new int[4];
        int[] ip_int_end = new int[4];
        for (int i = 0; i < ip_start.getAddress().length; i++) {
            ip_int_st[i] = 0xff & (int) ip_start.getAddress()[i];
            ip_int_end[i] = 0xff & (int) ip_end.getAddress()[i];
        }

        // int count =0;
        while (!compareIpStructure(ip_int_st, ip_int_end)) {
            if (ip_int_st[3] < 255) ip_int_st[3]++;
            else {
                ip_int_st[2]++;
                ip_int_st[3] = 0;
            }
            if (ip_int_st[2] == 255) {
                ip_int_st[1]++;
                ip_int_st[2] = 0;
            }
            if (ip_int_st[1] == 255) {
                ip_int_st[0]++;
                ip_int_st[1] = 0;
            }

            list_ip.add(ip_int_st[0] + "." + ip_int_st[1] + "." + ip_int_st[2] + "." + ip_int_st[3]);
            // count++;
        }
        // System.out.println(count);
        list_ip.remove(list_ip.size() - 1);
        for (String x : list_ip) {
            System.out.println(x);
        }
    }

    public static boolean compareIpStructure(int[] arr1, int[] arr2) throws UnknownHostException {
        String tmp_ip1 = arr1[0] + "." + arr1[1] + "." + arr1[2] + "." + arr1[3];
        String tmp_ip2 = arr2[0] + "." + arr2[1] + "." + arr2[2] + "." + arr2[3];
        return InetAddress.getByName(tmp_ip1).equals(InetAddress.getByName(tmp_ip2));

    }
}
