package EmpresaApp;

/**
* EmpresaApp/EmpresaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Empresa.idl
* lunes 14 de mayo de 2018 08:07:04 PM COT
*/

public final class EmpresaHolder implements org.omg.CORBA.portable.Streamable
{
  public EmpresaApp.Empresa value = null;

  public EmpresaHolder ()
  {
  }

  public EmpresaHolder (EmpresaApp.Empresa initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = EmpresaApp.EmpresaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    EmpresaApp.EmpresaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return EmpresaApp.EmpresaHelper.type ();
  }

}
