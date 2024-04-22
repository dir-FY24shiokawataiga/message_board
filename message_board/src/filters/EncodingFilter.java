package filters;

import java.io.IOException;
import java.security.PublicKey;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.apache.catalina.connector.Response;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain;

@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter
{
    public EncodingFilter() 
    {
        super();
    }
    
    public void destroy() 
    {
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
        {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            
            chain.doFilter(request,response);
        }
            
     public void init(FilterConfig fConfig) throws ServletException{
     } 
    
}

    
