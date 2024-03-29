import java.util.ArrayList;
import java.util.Scanner;

import view.InvoiceView;
import vn.edu.ptit.Invoice;
import vn.edu.ptit.Rule;
import vn.edu.ptit.Subject;

class PaymentController
{
    private Invoice invoice;
    private Rule rule;
    private Student student;
    private Subject subject;

    public PaymentController()
    {
        Scanner sc = new Scanner(System.in);
        String maSV = sc.nextLine();
        String tenSV = sc.nextLine();
        int soMonHoc = Integer.parseInt(sc.nextLine());
        String maMonHoc;
        String tenMonHoc;
        int soTinChi;
        student = new Student(maSV, tenSV);
        double sum = 0;
        ArrayList<Subject> arrayList = new ArrayList<>();
        while (soMonHoc-- > 0)
        {
            maMonHoc = sc.nextLine();
            tenMonHoc = sc.nextLine();
            soTinChi = Integer.parseInt(sc.nextLine());
            arrayList.add(new Subject(tenMonHoc, maMonHoc, soTinChi));
        }
        String soQD = sc.nextLine();
        String tenQD = sc.nextLine();
        double donGia = Double.parseDouble(sc.nextLine());
        for (Subject i : arrayList)
            sum += donGia * i.getCredit();
        rule = new Rule(soQD, tenQD, sum);
        invoice = new Invoice(rule);
        invoice.setAlSubject(arrayList);
        invoice.setAmount(sum);
        invoice.setSt(student);
    }

    public Invoice getInvoice()
    {
        return invoice;
    }
}
public class HELLOJAR {
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
    public static void main1196054(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
    public static void main9968108(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
    public static void main239010(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
    public static void main7316700(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}
