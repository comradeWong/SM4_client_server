import org.rcisoft.SM4;
import org.rcisoft.SM4_Context;
import org.rcisoft.Util;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SM4Utils {
//	private String secretKey = "";
//    private String iv = "";
//    private boolean hexString = false;

    public String secretKey = "";
    private String iv = "";
    public boolean hexString = false;

    public SM4Utils()
    {
    }
//
//    public byte encryptData_ECB1(byte[] inputStream){
//        try
//        {
//            SM4_Context ctx = new SM4_Context();
//            ctx.isPadding = true;
//            ctx.mode = SM4.SM4_ENCRYPT;
//
//            byte[] keyBytes;
//            if (hexString)
//            {
//                keyBytes = Util.hexStringToBytes(secretKey);
//            }
//            else
//            {
//                keyBytes = secretKey.getBytes();
//            }
//
//            SM4 sm4 = new SM4();
//            sm4.sm4_setkey_enc(ctx, keyBytes);
//            String cipherText = new BASE64Encoder().encode(inputStream);
//            if (cipherText != null && cipherText.trim().length() > 0)
//            {
//                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
//                Matcher m = p.matcher(cipherText);
//                cipherText = m.replaceAll("");
//            }
//            return cipherText;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return (Byte) null;
//        }
//    }

    public String encryptData_ECB(String plainText)
    {
        try
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_ENCRYPT;

            byte[] keyBytes;
            if (hexString)
            {
                keyBytes = Util.hexStringToBytes(secretKey);
            }
            else
            {
                keyBytes = secretKey.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("UTF-8"));
            String cipherText = new BASE64Encoder().encode(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0)
            {
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(cipherText);
                cipherText = m.replaceAll("");
            }
            return cipherText;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String decryptData_ECB(String cipherText)
    {
        try
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_DECRYPT;

            byte[] keyBytes;
            if (hexString)
            {
                keyBytes = Util.hexStringToBytes(secretKey);
            }
            else
            {
                keyBytes = secretKey.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
            return new String(decrypted, "UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String encryptData_CBC(String plainText)
    {
        try
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_ENCRYPT;

            byte[] keyBytes;
            byte[] ivBytes;
            if (hexString)
            {
                keyBytes = Util.hexStringToBytes(secretKey);
                ivBytes = Util.hexStringToBytes(iv);
            }
            else
            {
                keyBytes = secretKey.getBytes();
                ivBytes = iv.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, plainText.getBytes("UTF-8"));
            String cipherText = new BASE64Encoder().encode(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0)
            {
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(cipherText);
                cipherText = m.replaceAll("");
            }
            return cipherText;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String decryptData_CBC(String cipherText)
    {
        try
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_DECRYPT;

            byte[] keyBytes;
            byte[] ivBytes;
            if (hexString)
            {
                keyBytes = Util.hexStringToBytes(secretKey);
                ivBytes = Util.hexStringToBytes(iv);
            }
            else
            {
                keyBytes = secretKey.getBytes();
                ivBytes = iv.getBytes();
            }

            SM4 sm4 = new SM4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, new BASE64Decoder().decodeBuffer(cipherText));
            return new String(decrypted, "UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException
    {
        String plainText = "{" +
                "\"pageNu\":1," +
                "\"pageSize\":10," +
                "\"pages\":1," +
                "\"rows\":[" +
                "{" +
                "\"businessId\":\"e6ae30ef46104e2da83e6b29237cefc7\"," +
                "\"createBy\":null," +
                "\"createDate\":\"2020-06-11 09:02:50\"," +
                "\"delFlag\":\"0\"," +
                "\"flag\":\"1\"," +
                "\"groupCode\":\"demaxiya1\"," +
                "\"groupName\":\"hello\"," +
                "\"remarks\":null," +
                "\"token\":null," +
                "\"updateBy\":null," +
                "\"updateDate\":\"2020-06-11 09:02:50\"" +
                "}" +
                "]," +
                "\"total\":1" +
                "}";

        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = "FFFAAA333666DDDB";
        sm4.hexString = false;

        System.out.println("ECB模式加密");
        String cipherText = sm4.encryptData_ECB(plainText);
        System.out.println("密文: " + cipherText);
        System.out.println("");

        plainText = sm4.decryptData_ECB("tnqADSUy5/QS3yBmSq229g==");
        System.out.println("明文: " + plainText);
        System.out.println("");

//        sm4.decryptData_ECB(cipherText);

    }
}
