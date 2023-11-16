using Microsoft.Data.SqlClient;
using MySql.Data.MySqlClient;
using Microsoft;
using System.ComponentModel.DataAnnotations;

namespace WIL_Project_v2.Models
{
    public class SignIn
    {
            
            [Key]
            public int Id { get; set; }
            public string Email { get; set; }
            public string Password { get; set; }
            
        public bool AuthenticateUser()
        {
            string connectionString = "Server=tcp:kenny-computer.database.windows.net,1433;Initial Catalog=donations;Persist Security Info=False;User ID=admin1;Password=Humbo=thurm2;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";
            try
            {
                using MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                string query = "Select Count(*) From SignIn Where Id = @Id, Email = @Email AND Password = @Password";
                using MySqlCommand cmd = new MySqlCommand(query, connection);
                cmd.Parameters.AddWithValue("@Id", Id);
                cmd.Parameters.AddWithValue("@Email", Email);
                cmd.Parameters.AddWithValue("@Password", Password);

                int count = Convert.ToInt32(cmd.ExecuteScalar());
                return count > 0;
            }
            catch (Exception ex)
            {

                Console.WriteLine($"Error: {ex.Message}");
                return false;
            }

        }


       
    }
}

