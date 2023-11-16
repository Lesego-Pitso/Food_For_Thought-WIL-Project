using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.ComponentModel.DataAnnotations;

namespace WIL_Project_v2.Pages
{
    public class GetInvovled_PageModel : PageModel
    {
        [BindProperty]
        [Required(ErrorMessage = "The First Name is required")]
        public string FirstName { get; set; } = "";

        [BindProperty]
        [Required(ErrorMessage = "The last Name is required")]
        public string LastName { get; set; } = "";

        [BindProperty]
        [Required(ErrorMessage = "The Email is required")]
        public string Email { get; set; } = "";


        [BindProperty]
        [Required(ErrorMessage = "The Subject is required")]
        public string Subject { get; set; } = "";



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

            FirstName = "";
            LastName = "";

            Subject = "";


            ModelState.Clear();
        }
    }
}
