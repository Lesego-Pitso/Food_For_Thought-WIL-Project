using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using WIL_Project_v2.Data;
using WIL_Project_v2.Models;
using Microsoft.Data.SqlClient;
using MySql.Data.MySqlClient;
using System.ComponentModel.DataAnnotations;

namespace WIL_Project_v2.Pages
{
    public class SignIn_PageModel : PageModel
    {

        [BindProperty]
        [Required(ErrorMessage = "The Email is required")]
        public string Email { get; set; } = "";
        [BindProperty]
        [Required(ErrorMessage = "The Password is required")]
        public string Password { get; set; } = "";

        public string successMessage = "";
        public string errorMessage = "";
        public void OnGet()
        {
        }

        public void OnPost()
        {
            if (!ModelState.IsValid)
            {
                errorMessage = "Data validation failed";
                return;
            }

            successMessage = "Your message has been received";

            Email = "";
            Password = "";

            ModelState.Clear();
        }

        public bool AuthenticateUser()
        {
            string connectionString = "Server=tcp:kenny-computer.database.windows.net,1433;Initial Catalog=donations;Persist Security Info=False;User ID=admin1;Password=Humbo=thurm2;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";
            try
            {
                using MySqlConnection connection = new MySqlConnection(connectionString);
                connection.Open();

                string query = "Select Count(*) From SignIn Where Email = @Email AND Password = @Password";
                using MySqlCommand cmd = new MySqlCommand(query, connection);
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
